package com.huihui.client.strategy.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName Utils
 * @Description TODO
 * Author huihui
 * Date 16/05/19 下午 12:16
 * Version 1.0
 */
public class StrategyUtils {

    private static final String _CLAZZ_TITLE = "com.huihui.netty.strategy.server.";

    private static final Logger LOGGER = LoggerFactory.getLogger(StrategyUtils.class);

    public static Object createJavaBean(int type , String [] clazzName){
        if(type >=0 && type < clazzName.length){
            Class<?> handler = null;
            Object obj = null;
            try {
                handler = Class.forName(_CLAZZ_TITLE+clazzName[type]);
                try {
                    if(handler != null){
                        obj = handler.newInstance();
                    }
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                return obj;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else{
            LOGGER.error("传递的type参数有误type = "+type);
        }
        return null;
    }

    /**
     * 将class变为javabean
     * @param clazz
     * @return
     */
    public static Object classToJava(Class<?> clazz){
        Object obj = null;
        if(clazz != null){
            try{
                obj = clazz.newInstance();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return obj;
    }


}
