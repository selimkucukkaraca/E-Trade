package com.example.etrade.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SellerCommentDto {

    private String title;
    private String body;
    private int star;
    private SellerDto sellerDto;
    private UserDto userDto;

}