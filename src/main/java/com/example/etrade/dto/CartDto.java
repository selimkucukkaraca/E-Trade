package com.example.etrade.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
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