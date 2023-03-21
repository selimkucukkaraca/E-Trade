package com.example.etrade.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ProductCommentDto {

    private String title;
    private String body;
    private int star;
    private UserDto userDto;
    private ProductDto productDto;

}