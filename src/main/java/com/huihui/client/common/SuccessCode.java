package com.huihui.client.common;

/**
 * @className: SuccessCode
 * @description:
 * @author: huihui
 * @createDate: 2019-09-10
 * @version: 1.0
 */
public enum  SuccessCode {

    SUCCESS_UPDATE(20001,"消息修改成功"),

    SUCCESS_SAVE(20002,"消息添加成功"),

    SUCCESS_QUERY(20003,"消息查询成功"),

    SUCCESS_DELETE(20004,"消息删除成功"),

    SUCCESS_HEARD(20005,"心跳处理ok"),

    SUCCESS_LOGIN(20006,"用户登录成功")
    ;




    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    SuccessCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
