package com.huihui.client.strategy.server;

import com.alibaba.fastjson.JSONObject;
import com.huihui.client.common.SuccessCode;
import com.huihui.client.pojo.ReadMessage;
import com.huihui.client.pojo.ReturnMessage;
import com.huihui.client.strategy.common.HandlerStrategy;
import com.huihui.client.util.ClientUtil;
import io.netty.channel.ChannelHandlerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @className: Login
 * @description:
 * @author: huihui
 * @createDate: 2019-09-24
 * @version: 1.0
 */
public class Login extends HandlerStrategy {

    private static final Logger LOGGER = LoggerFactory.getLogger(Login.class);

    @Override
    public void messageHandle(ReadMessage message, ChannelHandlerContext ctx) {
        if(checkFrom(message)){
            if(message.getCode() == SuccessCode.SUCCESS_LOGIN.getCode()){
                //登录成功
                LOGGER.info("Login#messageHandle客户端登录成功！");
            }else{
                LOGGER.error("Login#messageHandle客户端登录失败!错误码："+message.getCode()+"错误原因："+message.getMessage()+"错误内容："+ message.getContent());
                //执行重连操作
                ClientUtil.login();
            }
        }
    }
}
