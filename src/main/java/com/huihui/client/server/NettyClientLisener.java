package com.huihui.client.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @ClassName NettyClientLisener
 * @Descrition TODO
 * @Author hh
 * @Date 19-5-30 上午10:15
 * @Veriosn 1.0
 **/
@WebListener
public class NettyClientLisener implements ServletContextListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(NettyClientLisener.class);

    /**
     * 注入NettyServer
     */
    @Autowired
    private NettyClientServer nettyClientServer;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        Thread thread = new Thread(new NettyServerThread());
        // 启动netty客户端服务
        thread.start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    /**
     * netty服务启动线程 . <br>
     *
     * @author hkb
     */
    private class NettyServerThread implements Runnable {

        @Override
        public void run() {
            LOGGER.info("---启动netty监听---");
            nettyClientServer.run();
        }
    }
}
