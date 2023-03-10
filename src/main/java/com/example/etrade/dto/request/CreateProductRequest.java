package com.example.etrade.dto.request;

import lombok.Data;

@Data
public class CreateProductRequest {
    private String productName;
    private String productDetails;
    private double productPrice;
    private int stock;
    private String productImageUrl;
    private String brand;
    private String categoryName;
}
