package org.demo.springboot.bean;

/**
 * 服务端接收发送给指定用户的消息
 */
public class SendToUserMessage {
    private String username;
    private String message;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
