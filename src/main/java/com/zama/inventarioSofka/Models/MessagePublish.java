package com.zama.inventarioSofka.Models;

import com.zama.inventarioSofka.Models.DTO.ProductDTO;

import java.time.LocalDateTime;
import java.util.List;

public class MessagePublish {
    private String publishDate = LocalDateTime.now().toString();
    private String action;
    private String typeMessage;
    private String message;
    private List<ProductDTO> product;

    public MessagePublish(String action, String typeMessage, String message) {
        this.action = action;
        this.typeMessage = typeMessage;
        this.message = message;
    }

    public MessagePublish(String action, String typeMessage, String message, List<ProductDTO> product) {
        this.action = action;
        this.typeMessage = typeMessage;
        this.message = message;
        this.product = product;
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
