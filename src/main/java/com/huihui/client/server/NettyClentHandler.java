package com.huihui.client.server;

import com.alibaba.fastjson.JSONObject;
import com.huihui.client.pojo.ReqMessage;
import com.huihui.client.strategy.common.Context;
import com.huihui.client.strategy.common.HandlerFactory;
import com.huihui.client.strategy.common.HandlerStrategy;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.websocketx.CloseWebSocketFrame;
import io.netty.handler.codec.http.websocketx.PongWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketHandshakeException;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName NettyClentHandler
 * @Descrition 在该类中进行消息接收
 * @Author hh
 * @Date 19-5-30 上午10:15
 * @Veriosn 1.0
 **/
public class NettyClentHandler extends SimpleChannelInboundHandler<Object> {

    private static final Logger LOGGER = LoggerFactory.getLogger(NettyClentHandler.class);

    private final WebSocketClientHandshaker handshaker;
    private ChannelPromise handshakeFuture;

    public NettyClentHandler(WebSocketClientHandshaker handshaker) {
        this.handshaker = handshaker;
    }

    public ChannelFuture handshakeFuture() {
        return handshakeFuture;
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        handshakeFuture = ctx.newPromise();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        handshaker.handshake(ctx.channel());
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        System.out.println("WebSocket Client disconnected!");
    }

    @Override
    public void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        Channel ch = ctx.channel();
        if (!handshaker.isHandshakeComplete()) {
            try {
                handshaker.finishHandshake(ch, (FullHttpResponse) msg);
                LOGGER.info("WebSocket Client connected!");
                handshakeFuture.setSuccess();
            } catch (WebSocketHandshakeException e) {
                LOGGER.info("WebSocket Client failed to connect");
                handshakeFuture.setFailure(e);
            }
            return;
        }

        if (msg instanceof FullHttpResponse) {
            FullHttpResponse response = (FullHttpResponse) msg;
            throw new IllegalStateException(
                    "Unexpected FullHttpResponse (getStatus=" + response.status() +
                            ", content=" + response.content().toString(CharsetUtil.UTF_8) + ')');
        }

        WebSocketFrame frame = (WebSocketFrame) msg;
        if (frame instanceof TextWebSocketFrame) {
            TextWebSocketFrame textFrame = (TextWebSocketFrame) frame;
            ReqMessage message = null;
            if(textFrame!=null){
                try{
                    message = JSONObject.parseObject(((TextWebSocketFrame) msg).text(), ReqMessage.class);
                }catch (Exception e){
                    LOGGER.error("NettyServerHandler#channelRead0消息解析异常！",e);
                }
                Context context = new Context();
                HandlerFactory factory = new HandlerFactory();
                HandlerStrategy strategy = (HandlerStrategy) factory.createHandlerStraategy(message.getType());
                context.setHandlerStrategy(strategy);
                try{
                    context.result(message,ctx);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }else{
                LOGGER.error("NettyServerHandler#channelRead0消息内容为空！");
            }
            LOGGER.info("WebSocket Client received message: " + textFrame.text());
        } else if (frame instanceof PongWebSocketFrame) {
            LOGGER.info("WebSocket Client received pong");
        } else if (frame instanceof CloseWebSocketFrame) {
            LOGGER.info("WebSocket Client received closing");
            ch.close();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        if (!handshakeFuture.isDone()) {
            handshakeFuture.setFailure(cause);
        }
        ctx.close();
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        LOGGER.info("{} -> [客户端心跳监测发送] 通道编号：{}", this.getClass().getName(), ctx.channel().id());
        if (evt instanceof IdleStateEvent) {
            ctx.writeAndFlush(new TextWebSocketFrame("ping-pong-ping-pong"));
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }
}
