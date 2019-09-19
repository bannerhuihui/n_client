package com.huihui.client.strategy.common;

import com.huihui.client.pojo.ReqMessage;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @ClassName HandlerStrategy
 * @Descrition 策略组装类
 * @Author hh
 * @Date 19-5-30 下午1:42
 * @Veriosn 1.0
 **/
public abstract class HandlerStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(HandlerStrategy.class);

    public abstract void messageHandle(ReqMessage message, ChannelHandlerContext ctx);
}
