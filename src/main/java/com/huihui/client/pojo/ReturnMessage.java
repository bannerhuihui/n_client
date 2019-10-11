package com.huihui.client.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * @className: ResMessage
 * @description:
 * @author: huihui
 * @createDate: 2019-09-11
 * @version: 1.0
 */
public class ReturnMessage implements Serializable {

    private static final long serialVersionUID = 5226437370703346792L;

    private String from; //消息来源
    private String[] to; //要发送到哪里
    private String subject; //标题
    private String content; //内容 （base64）
    private int type; //消息类型 1 2 3 4
    private String[] cc; //将消息拷贝给谁 和to一样
    private int contentType; //消息类型
    private String charset; //编码集
    private int level; //级别 默认0
    private String[] tags; // 标签
    private List<Object> attachments; //附件
    private String references; //关联主题ID
    private String inReplyTo; //回复消息的ID
    private String subjectId; //主题id
    private long creatTime; //创建时间
    private long lastUpdTime; //最后更新时间
    private int state; // 消息发送状态
    private String token;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String[] getTo() {
        return to;
    }

    public void setTo(String[] to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String[] getCc() {
        return cc;
    }

    public void setCc(String[] cc) {
        this.cc = cc;
    }

    public int getContentType() {
        return contentType;
    }

    public void setContentType(int contentType) {
        this.contentType = contentType;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public List<Object> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Object> attachments) {
        this.attachments = attachments;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }

    public String getInReplyTo() {
        return inReplyTo;
    }

    public void setInReplyTo(String inReplyTo) {
        this.inReplyTo = inReplyTo;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public long getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(long creatTime) {
        this.creatTime = creatTime;
    }

    public long getLastUpdTime() {
        return lastUpdTime;
    }

    public void setLastUpdTime(long lastUpdTime) {
        this.lastUpdTime = lastUpdTime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
