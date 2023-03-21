package com.example.etrade.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class SellerCommentDto {

    private String title;
    private String body;
    private int star;
    private SellerDto sellerDto;
    private UserDto userDto;

}