package com.huihui.client.util;

import com.alibaba.fastjson.JSONObject;
import com.huihui.client.common.ProConfig;
import com.huihui.client.common.ProFunctionName;
import com.huihui.client.pojo.ReturnMessage;
import com.huihui.client.server.NettyClientServer;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @className: ClientUtil
 * @description:
 * @author: huihui
 * @createDate: 2019-09-23
 * @version: 1.0
 */
public class ClientUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientUtil.class);

    /**
     * 给服务端发送消息
     *
     * @param message
     * @return
     */
    public static boolean saveMessage(ReturnMessage message, String tag) {
        LOGGER.info("发送消息到服务器，功能名称：" + tag + "发送参数为：" + JSONObject.toJSONString(message));
        boolean flag = false;
        Channel channel = NettyClientServer.CHANNEL;
        if (channel != null) {
            WebSocketFrame frame = new TextWebSocketFrame(JSONObject.toJSONString(message));
            channel.writeAndFlush(frame);
            flag = true;
        }
        LOGGER.info("发送消息到服务器，功能名称：" + tag + "发送：" + (flag ? "成功！" : "失败！"));
        return flag;
    }

    public static boolean login() {
        ReturnMessage returnMessage = new ReturnMessage();
        returnMessage.setType(ProFunctionName.USER_LOGIN.getCode());
        returnMessage.setFrom(ProConfig.CLIENT_NAME.getCode());
        returnMessage.setContent(ProConfig.CLIENT_NAME.getMessage());
        if (NettyClientServer.CHANNEL != null) {
            return saveMessage(returnMessage, ProFunctionName.USER_LOGIN.getMessage());
        }
        return false;
    }
}
