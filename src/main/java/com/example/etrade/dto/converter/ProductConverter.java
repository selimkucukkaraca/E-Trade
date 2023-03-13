package com.example.etrade.dto.converter;

import com.example.etrade.dto.ProductDto;
import com.example.etrade.dto.request.CreateProductRequest;
import com.example.etrade.model.Category;
import com.example.etrade.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {

    private final BrandConverter brandConverter;

    public ProductConverter(BrandConverter brandConverter) {
        this.brandConverter = brandConverter;
    }

    public ProductDto convert(Product from){
        return new ProductDto(
                from.getProductName(),
                from.getProductDetails(),
                from.getProductPrice(),
                from.getStock(),
                from.getProductImageUrl(),
                from.getProductId(),
                brandConverter.convert(from.getBrand())
        );
    }

    public Product toEntity(CreateProductRequest request){
        return new Product(
                request.getProductName(),
                request.getProductDetails(),
                request.getProductPrice(),
                request.getStock(),
                request.getProductImageUrl(),
                new Category(request.getCategoryName())
        );
    }
}