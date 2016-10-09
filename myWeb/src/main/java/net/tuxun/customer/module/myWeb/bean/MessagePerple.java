package net.tuxun.customer.module.myWeb.bean;

/**
 * 数据库表[message_perple]的数据模型
 * 
 * 
 * 
 * @author pand
 * 
 */

@SuppressWarnings("serial")
public class MessagePerple implements java.io.Serializable {

    /** 默认构造函数 */
    public MessagePerple() {
    }
    
    /** 全参构造函数 */
    public MessagePerple(java.lang.Object id, java.lang.Object messagePerple, java.lang.Object messagePerpleIp, java.lang.Object createTime, java.lang.Object messageContent) {
      this.id = id;
      this.messagePerple = messagePerple;
      this.messagePerpleIp = messagePerpleIp;
      this.createTime = createTime;
      this.messageContent = messageContent;
    }
    
    // 编号 
    private java.lang.Object id;
    // 留言人姓名 
    private java.lang.Object messagePerple;
    // 留言人ip 
    private java.lang.Object messagePerpleIp;
    // 留言时间 
    private java.lang.Object createTime;
    // 留言内容 
    private java.lang.Object messageContent;
     
    public  java.lang.Object getId() {
        return this.id;
    }
    public void setId(java.lang.Object id) {
        this.id = id;
    }
    public  java.lang.Object getMessagePerple() {
        return this.messagePerple;
    }
    public void setMessagePerple(java.lang.Object messagePerple) {
        this.messagePerple = messagePerple;
    }
    public  java.lang.Object getMessagePerpleIp() {
        return this.messagePerpleIp;
    }
    public void setMessagePerpleIp(java.lang.Object messagePerpleIp) {
        this.messagePerpleIp = messagePerpleIp;
    }
    public  java.lang.Object getCreateTime() {
        return this.createTime;
    }
    public void setCreateTime(java.lang.Object createTime) {
        this.createTime = createTime;
    }
    public  java.lang.Object getMessageContent() {
        return this.messageContent;
    }
    public void setMessageContent(java.lang.Object messageContent) {
        this.messageContent = messageContent;
    }
}


