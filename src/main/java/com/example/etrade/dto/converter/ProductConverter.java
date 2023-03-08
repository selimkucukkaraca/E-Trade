package com.example.etrade.dto.converter;

import com.example.etrade.dto.ProductDto;
import com.example.etrade.dto.request.CreateProductRequest;
import com.example.etrade.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    public ProductDto convert(Product from){
        return new ProductDto(
                from.getProductName(),
                from.getProductBrand(),
                from.getProductDetails(),
                from.getProductPrice(),
                from.isStock(),
                from.getProductImageUrl()
        );
    }

    public Product toEntity(CreateProductRequest request){
        return new Product(
                request.getProductName(),
                request.getProductBrand(),
                request.getProductDetails(),
                request.getProductPrice(),
                request.getProductImageUrl()
        );
    }
}
