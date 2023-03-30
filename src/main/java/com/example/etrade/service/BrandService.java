package com.example.etrade.service;

import com.example.etrade.dto.BrandDto;
import com.example.etrade.dto.converter.BrandConverter;
import com.example.etrade.dto.request.CreateBrandRequest;
import com.example.etrade.exception.NotFoundException;
import com.example.etrade.model.Brand;
import com.example.etrade.repository.BrandRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BrandService {

    private final BrandRepository brandRepository;
    private final BrandConverter brandConverter;

    public BrandService(BrandRepository brandRepository, BrandConverter brandConverter) {
        this.brandRepository = brandRepository;
        this.brandConverter = brandConverter;
    }

    @CachePut(value = "brands", key = "#request")
    public BrandDto save(CreateBrandRequest request) {
        var saved = brandConverter.toEntity(request);
        brandRepository.save(saved);
        return brandConverter.convertToDto(saved);
    }

    @CacheEvict(value = "brands", key = "#brandId")
    public void deleteBrandByBrandId(String brandId) {
        var brand = getBrandByBrandId(brandId);
        brandRepository.delete(brand);
    }

    @Cacheable(value = "brands", key = "#brandId")
    public Brand getBrandByBrandId(String brandId) {
        return brandRepository.findBrandByBrandId(brandId)
                .orElseThrow(() -> new NotFoundException(""));
    }

    @Cacheable(value = "brands", key = "#brand")
    public Brand getBrandByBrand(String brand) {
        return brandRepository.findBrandByBrand(brand);
    }
}