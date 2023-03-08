package com.example.etrade.dto.request;

import lombok.Data;

@Data
public class CreateCartRequest {

    private double quantity;
    private String productName;
    private String productDetails;
    private double productPrice;
    private String productImageUrl;
}
