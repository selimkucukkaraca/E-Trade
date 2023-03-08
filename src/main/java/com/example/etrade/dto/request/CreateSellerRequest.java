package com.example.etrade.dto.request;

import lombok.Data;

@Data
public class CreateSellerRequest {

    private String username;
    private String password;
    private String mail;
    private String imageUrl;
}
