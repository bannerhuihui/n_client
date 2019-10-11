package com.huihui.client.common;

/**
 * @className: ProFunctionName
 * @description:
 * @author: huihui
 * @createDate: 2019-09-10
 * @version: 1.0
 */
public enum  ProFunctionName {

    USER_LOGIN(1,"用户登录"),
    JAVA_CLIENT_HEARD_CONTENT_TYPE(6,"java客户端心跳"),
    HEARD(2,"心跳")
    ;

    private int code;

    private String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ProFunctionName(int code, String message){
        this.code = code;
        this.message = message;
    }

}
