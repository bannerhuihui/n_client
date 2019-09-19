package com.huihui.client.server;

import com.alibaba.fastjson.JSONObject;
import com.huihui.client.server.util.SslUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.HttpClientCodec;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshakerFactory;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketVersion;
import io.netty.handler.codec.http.websocketx.extensions.compression.WebSocketClientCompressionHandler;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.ssl.SslHandler;
import io.netty.handler.timeout.IdleStateHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import java.net.*;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName NettyClientServer
 * @Descrition TODO
 * @Author hh
 * @Date 19-5-30 上午10:14
 * @Veriosn 1.0
 **/
@Component
public class NettyClientServer {


    private static Channel CHANNEL = null;

    private static final Logger LOGGER = LoggerFactory.getLogger(NettyClientServer.class);

    private static final String type = "JKS";

    private static final String URL = "wss://www.hubanqipei.com/ws";

    @Value("${netty.action}")
    private String path;

    @Value("${netty.password}")
    private String password;

    /**
     * 需要执行的连接方法
     */
    public void run() {
        LOGGER.info("监听进入到netty启动程序！");
        URI uri = null;
        try {
            uri = new URI(URL);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        if (uri != null) {
            EventLoopGroup group = new NioEventLoopGroup();
            final NettyClentHandler handler = new NettyClentHandler(WebSocketClientHandshakerFactory.newHandshaker(uri, WebSocketVersion.V13, null, true, new DefaultHttpHeaders()));

            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(group).channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            SSLContext sslContext = SslUtil.createSSLContext(type,path,password);
                            SSLEngine engine = sslContext.createSSLEngine();
                            engine.setUseClientMode(true);
                            ChannelPipeline p = ch.pipeline();
                            p.addLast(new IdleStateHandler(30,30,30, TimeUnit.MINUTES));
                            p.addLast(new SslHandler(engine));
                            p.addLast(new HttpClientCodec());
                            p.addLast(new HttpObjectAggregator(8192));
                            p.addLast(WebSocketClientCompressionHandler.INSTANCE);
                            p.addLast(new LineBasedFrameDecoder(1024));
                            p.addLast(new StringDecoder());
                            p.addLast(handler);
                        }
                    });
            try {
                Channel ch = bootstrap.connect(uri.getHost(),13145).sync().channel();
                handler.handshakeFuture().sync();
                //连接成功后发送消息到服务端进行注册
                CHANNEL = ch;
                System.out.println(ch == null);
            } catch (Exception e) {
                LOGGER.error("连接服务器异常！",e);
                e.fillInStackTrace();
            }
        }

    }
}
