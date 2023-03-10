package com.example.etrade.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CartDto extends BaseDto {

    private List<ProductDto> productDto;
    private UserDto userDto;
    private String cartId;

    public CartDto(List<ProductDto> productDto, UserDto userDto) {
        this.productDto = productDto;
        this.userDto = userDto;
    }
}