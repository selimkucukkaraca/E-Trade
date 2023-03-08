package com.example.etrade.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto extends BaseDto{

    private String productName;
    private String productBrand;
    private String productDetails;
    private double productPrice;
    private boolean stock;
    private String productImageUrl;

}
