package com.example.etrade.service;

import com.example.etrade.dto.ProductDto;
import com.example.etrade.dto.converter.ProductConverter;
import com.example.etrade.dto.request.CreateProductRequest;
import com.example.etrade.exception.NotFoundException;
import com.example.etrade.model.Product;
import com.example.etrade.repository.ProductRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductConverter productConverter;

    public ProductService(ProductRepository productRepository, ProductConverter productConverter) {
        this.productRepository = productRepository;
        this.productConverter = productConverter;
    }

    @CachePut(value = "products", key = "#request")
    public ProductDto save(CreateProductRequest request) {
        var saved = productConverter.toEntity(request);
        productRepository.save(saved);
        return productConverter.convertToDto(saved);
    }

    @CacheEvict(value = "products", key = "#productId")
    public void deleteByProductId(String productId) {
        var product = getProductObjectByProductId(productId);
        productRepository.delete(product);
    }

    @Cacheable(value = "products", key = "#productId")
    public ProductDto getByProductId(String productId) {
        var fromDbProduct = productRepository.findProductByProductId(productId)
                .orElseThrow(() -> new NotFoundException("ProductId not found: " + productId));
        return productConverter.convertToDto(fromDbProduct);
    }

    @Cacheable(value = "products", key = "#productId")
    public Product getProductObjectByProductId(String productId) {
        return productRepository.findProductByProductId(productId)
                .orElseThrow(() -> new NotFoundException(""));
    }

    protected void updateProduct(Product product) {
        productRepository.save(product);
    }

}