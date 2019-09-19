package com.huihui.client.common;

/**
 * @className: MessageConfig
 * @description:
 * @author: huihui
 * @createDate: 2019-09-11
 * @version: 1.0
 */
public enum  MessageConfig {

    PZB_HEARD_CONTENT_TYPE(1,"配智宝心跳"),
    KF_HEARD_CONTENT_TYPE(2,"客服心跳"),
    GZH_HEARD_CONTENT_TYPE(3,"公众号心跳"),
    XCX_HEARD_CONTENT_TYPE(4,"小程序心跳"),
    APP_HEARD_CONTENT_TYPE(5,"APP心跳")
    ;

    private int type;
    private String message;

    public int getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    MessageConfig(int type,String message){
        this.type = type;
        this.message = message;
    }
}
