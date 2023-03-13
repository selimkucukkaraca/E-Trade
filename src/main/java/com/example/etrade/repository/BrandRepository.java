package com.example.etrade.repository;

import com.example.etrade.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,Long> {

    Brand findBrandByBrand(String brand);
    void deleteBrandByBrandId(String brandId);
}
