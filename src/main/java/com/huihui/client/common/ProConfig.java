package com.huihui.client.common;

/**
 * @className: ProConfig
 * @description:
 * @author: huihui
 * @createDate: 2019-09-10
 * @version: 1.0
 */
public enum ProConfig {

    LOGIN_PAR("token", "建立连接时的参数名称"),

    NETTY_URL("/ws", "netty url后缀"),

    CLIENT_NAME("CLI_9090","客户端名称"),

    SERVER_NAME("n_server","netty服务端名称"),

    HEARD_CONTENT("ping-pong-ping-pong","心跳发送字段")
    ;


    private String code;

    private String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ProConfig(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
