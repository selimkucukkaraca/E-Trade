package com.example.etrade.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartDto extends BaseDto {

    private double quantity;
    private String productName;
    private String productDetails;
    private double productPrice;
    private String productImageUrl;
}