package com.example.etrade.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateUserRequest {

    private String username;
    private String password;
    private String mail;
    private String imageUrl;

}