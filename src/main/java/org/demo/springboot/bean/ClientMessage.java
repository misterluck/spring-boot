package org.demo.springboot.bean;

/**
 * 广播发送客户端的消息
 */
public class ClientMessage {
    private String message;

    public ClientMessage() {
    }

    public ClientMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
