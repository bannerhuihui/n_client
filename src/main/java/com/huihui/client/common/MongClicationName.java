package com.huihui.client.common;

/**
 * @className: MongClicationName
 * @description:
 * @author: huihui
 * @createDate: 2019-09-06
 * @version: 1.0
 */
public enum  MongClicationName{

    MSG_ALL("msg_all","所有的reqMessage消息");

    private String name;

    private String message;

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    MongClicationName(String name, String message) {
        this.name = name;
        this.message = message;
    }
}
