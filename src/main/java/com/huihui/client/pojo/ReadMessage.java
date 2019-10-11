package com.huihui.client.pojo;

import java.io.Serializable;

/**
 * @className: ReqMessage
 * @description:
 * @author: huihui
 * @createDate: 2019-09-11
 * @version: 1.0
 */
public class ReadMessage implements Serializable {

    private static final long serialVersionUID = 6555319698705099485L;

    private String from;

    private String content;

    private int code;

    private int type;

    private String message;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
