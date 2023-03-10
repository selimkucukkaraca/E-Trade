package com.example.etrade.repository;

import com.example.etrade.dto.ProductDto;
import com.example.etrade.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<ProductDto> getProductByProductName(String productName);
    void deleteProductByProductId(String productId);
    Optional<Product> findProductByProductId(String productId);

}