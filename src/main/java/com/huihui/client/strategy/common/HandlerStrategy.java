package com.huihui.client.strategy.common;

import com.huihui.client.pojo.ReadMessage;
import com.huihui.client.pojo.ReturnMessage;
import com.huihui.client.strategy.server.check.CheckFrom;
import com.huihui.client.strategy.server.check.impl.CheckFromDefault;
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

    private CheckFrom checkFrom;

    public abstract void messageHandle(ReadMessage message, ChannelHandlerContext ctx);


    public boolean checkFrom(ReadMessage message){
        this.checkFrom = new CheckFromDefault();
        return checkFrom.checkFrom(message);
    }
}
