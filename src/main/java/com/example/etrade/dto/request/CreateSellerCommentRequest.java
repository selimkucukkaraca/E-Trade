package com.example.etrade.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateSellerCommentRequest {

    private String title;
    private String body;
    private int star;
    private String sellerMail;
    private String userMail;

}