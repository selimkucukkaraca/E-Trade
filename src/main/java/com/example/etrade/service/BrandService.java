package com.example.etrade.service;

import com.example.etrade.dto.BrandDto;
import com.example.etrade.dto.converter.BrandConverter;
import com.example.etrade.dto.request.CreateBrandRequest;
import com.example.etrade.exception.NotFoundException;
import com.example.etrade.model.Brand;
import com.example.etrade.repository.BrandRepository;
import org.springframework.stereotype.Service;

@Service
public class BrandService {

    private final BrandRepository brandRepository;
    private final BrandConverter brandConverter;

    public BrandService(BrandRepository brandRepository, BrandConverter brandConverter) {
        this.brandRepository = brandRepository;
        this.brandConverter = brandConverter;
    }

    public BrandDto save(CreateBrandRequest request) {
        var saved = brandConverter.toEntity(request);
        brandRepository.save(saved);
        return brandConverter.convertToDto(saved);
    }

    public void deleteBrandByBrandId(String brandId) {
        var brand = getBrandByBrandId(brandId);
        brandRepository.delete(brand);
    }

    public Brand getBrandByBrandId(String brandId) {
        return brandRepository.findBrandByBrandId(brandId)
                .orElseThrow(() -> new NotFoundException(""));
    }

    public Brand getBrandByBrand(String brand) {
        return brandRepository.findBrandByBrand(brand);
    }
}