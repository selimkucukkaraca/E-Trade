package com.example.etrade.dto.request;

import lombok.Data;

@Data
public class CreateProductRequest {
    private String productName;
    private String productBrand;
    private String productDetails;
    private double productPrice;
    private String productImageUrl;
}
