package com.huihui.client.strategy.common;


import com.huihui.client.strategy.common.util.StrategyUtils;

/**
 * 工厂模式
 * @ClassName HandlerFactory
 * @Description TODO
 * Author huihui
 * Date 15/05/19 下午 12:59
 * Version 1.0
 */
public class HandlerFactory {

    String [] clazzName = {
            "",
            "Login"
            };

    /**
     * handler状态类
     * @param type
     * @return
     */
    public Object createHandlerStraategy(int type){
        return StrategyUtils.createJavaBean(type,clazzName);
    }

}
