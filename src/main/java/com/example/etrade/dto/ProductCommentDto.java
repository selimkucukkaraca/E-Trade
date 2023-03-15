package com.example.etrade.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductCommentDto {

    private String title;
    private String body;
    private int star;
    private UserDto userDto;
    private ProductDto productDto;

}