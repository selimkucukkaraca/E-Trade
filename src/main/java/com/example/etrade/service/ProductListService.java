package com.example.etrade.service;

import com.example.etrade.dto.ProductDto;
import com.example.etrade.dto.converter.ProductConverter;
import com.example.etrade.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductListService {

    private final ProductRepository productRepository;
    private final ProductConverter productConverter;

    public ProductListService(ProductRepository productRepository,
                              ProductConverter productConverter) {
        this.productRepository = productRepository;
        this.productConverter = productConverter;
    }

    public List<ProductDto> getProductByProductName(String productName){
        return productRepository.getProductByProductName(productName);
    }



}