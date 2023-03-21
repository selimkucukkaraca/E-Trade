package com.example.etrade.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class SellerDto extends BaseDto {

    private String username;
    private String mail;
    private String imageUrl;
    private boolean isActive;
}
