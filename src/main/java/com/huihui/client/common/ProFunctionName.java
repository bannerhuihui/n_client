package com.huihui.client.common;

/**
 * @className: ProFunctionName
 * @description:
 * @author: huihui
 * @createDate: 2019-09-10
 * @version: 1.0
 */
public enum  ProFunctionName {

    USER_LOGIN(1,"用户登录");

    private int code;

    private String message;

    ProFunctionName(int code,String message){
        this.code = code;
        this.message = message;
    }

}
