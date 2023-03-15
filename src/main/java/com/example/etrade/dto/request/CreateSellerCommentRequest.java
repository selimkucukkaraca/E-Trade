package com.example.etrade.dto.request;

import lombok.Data;

@Data
public class CreateSellerCommentRequest {

    private String title;
    private String body;
    private int star;
    private String sellerMail;
    private String userMail;

}