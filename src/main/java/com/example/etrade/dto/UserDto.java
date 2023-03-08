package com.example.etrade.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto extends BaseDto {

    private String username;
    private String mail;
    private String imageUrl;
    private boolean isActive;

}