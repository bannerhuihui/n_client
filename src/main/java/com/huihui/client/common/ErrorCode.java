package com.huihui.client.common;

/**
 * @className: ErrorCode
 * @description:
 * @author: huihui
 * @createDate: 2019-09-06
 * @version: 1.0
 */
public enum ErrorCode{
    MESSAGE_FROM_NULL(10001,"from为null或空"),

    MESSAGE_LOGIN_OUT(10002, "登录超时"),

    MESSAGE_CONTENT_NULL(10003,"content内容为null或空"),

    MESSAGE_CONTENT_ERROR(10004,"content格式错误"),

    MESSAGE_TO_NULL(10005,"to的内容为null或空"),

    MESSAGE_TO_ERROR(10006,"to格式错误"),

    MESSAGE_CC_NULL(10007,"抄送内容为null或空"),

    MESSAGE_CC_ERROR(10008,"抄送格式错误"),

    MESSAGE_REFERENCES_NULL(10009,"主题内容为null或空"),

    MESSAGE_REFERENCES_ERROR(10010,"主题内容格式错误"),

    MESSAGE_UPDATE_ERROR(10011,"消息内容修改失败"),

    MESSAGE_SAVE_ERROR(10012,"消息内容添加失败"),

    MESSAGE_DELETE_ERROR(10013,"消息内容删除失败"),

    MESSAGE_QUERY_NULL(10014,"消息查询内容为null"),

    MESSAGE_QUERY_ERROR(10015,"消息查询异常"),

    MESSAGE_CONTENT_TYPE_ERROR(10016,"contentType类型错误")

    ;


    private Integer code;

    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
