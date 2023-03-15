package com.example.etrade.dto.request;

import lombok.Data;

@Data
public class CreateProductCommentRequest {

    private String title;
    private String body;
    private int star;
    private String userMail;
    private String productId;

}