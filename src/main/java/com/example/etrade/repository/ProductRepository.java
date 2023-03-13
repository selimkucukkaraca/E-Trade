package com.example.etrade.repository;

import com.example.etrade.model.Brand;
import com.example.etrade.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> getProductByProductName(String productName);
    void deleteProductByProductId(String productId);
    Optional<Product> findProductByProductId(String productId);
    Optional<Product> getProductByBrand(Brand brand);

}