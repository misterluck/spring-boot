package org.demo.springboot.bean;

public class ServerMessage {
    private String message;

    public ServerMessage() {
    }

    public ServerMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
