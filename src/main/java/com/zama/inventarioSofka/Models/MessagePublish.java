package com.zama.inventarioSofka.Models;

import java.time.LocalDateTime;

public class MessagePublish {
    private LocalDateTime publishDate = LocalDateTime.now();
    private String action;
    private String typeMessage;
    private String message;

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getTypeMessage() {
        return typeMessage;
    }

    public void setTypeMessage(String typeMessage) {
        this.typeMessage = typeMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessagePublish() {
    }

    public MessagePublish(String action, String typeMessage, String message) {
        this.action = action;
        this.typeMessage = typeMessage;
        this.message = message;
    }

    public MessagePublish(LocalDateTime publishDate, String action, String typeMessage, String message) {
        this.publishDate = publishDate;
        this.action = action;
        this.typeMessage = typeMessage;
        this.message = message;
    }

    @Override
    public String toString() {
        return "PublishMessage{" +
                "publishDate=" + publishDate +
                ", action='" + action + '\'' +
                ", typeMessage='" + typeMessage + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
