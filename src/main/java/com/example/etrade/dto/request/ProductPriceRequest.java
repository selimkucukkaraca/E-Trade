package com.example.etrade.dto.request;

import lombok.Data;

@Data
public class ProductPriceRequest {

    private String productId;
    private double newPrice;

}
