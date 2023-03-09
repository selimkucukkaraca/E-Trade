package com.example.etrade.repository;

import com.example.etrade.dto.ProductDto;
import com.example.etrade.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<ProductDto> getProductByProductName(String productName);
    void deleteProductByProductId(String productId);

}