package com.huihui.client.strategy.common;

import com.huihui.client.pojo.ReadMessage;
import io.netty.channel.ChannelHandlerContext;

/**
 *
 * @ClassName Context
 * @Description TODO
 * Author huihui
 * Date 15/05/19 上午 11:04
 * Version 1.0
 */
public class Context {
    //持有抽象策略角色的引用，用于客户端调用
    private HandlerStrategy handlerStrategy;

    //获取策略类
    public HandlerStrategy newHandlerStrategy(){
        return handlerStrategy;
    }

    //设置所需策略
    public void setHandlerStrategy(HandlerStrategy handeler){
        this.handlerStrategy = handeler;
    }

    //根据策略类返回结果
    public void result(ReadMessage message, ChannelHandlerContext ctx){
        handlerStrategy.messageHandle(message,ctx);
    }


}
