package com.example.etrade.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ConfirmedCartDto {

    private CartDto cartDto;
    private String cartId;

}