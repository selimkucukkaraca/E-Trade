package com.example.etrade.repository;

import com.example.etrade.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BrandRepository extends JpaRepository<Brand, Long> {

    Brand findBrandByBrand(String brand);

    Optional<Brand> findBrandByBrandId(String brandId);

}