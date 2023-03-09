package com.example.etrade.service;

import com.example.etrade.dto.ProductDto;
import com.example.etrade.dto.converter.ProductConverter;
import com.example.etrade.dto.request.CreateProductRequest;
import com.example.etrade.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductConverter productConverter;

    public ProductService(ProductRepository productRepository, ProductConverter productConverter) {
        this.productRepository = productRepository;
        this.productConverter = productConverter;
    }

    public ProductDto save(CreateProductRequest request){
        var saved = productConverter.toEntity(request);
        productRepository.save(saved);
        return productConverter.convert(saved);
    }

    public List<ProductDto> getProductByProductName(String productName){
        return productRepository.getProductByProductName(productName);
    }

    public void deleteByProductId(String productId){
        productRepository.deleteProductByProductId(productId);
    }


}