package com.example.etrade.dto.converter;

import com.example.etrade.dto.BrandDto;
import com.example.etrade.dto.request.CreateBrandRequest;
import com.example.etrade.model.Brand;
import org.springframework.stereotype.Component;

@Component
public class BrandConverter {

    public BrandDto convertToDto(Brand from) {
        return new BrandDto(
                from.getBrand(),
                from.getBrandId()
        );
    }

    public Brand toEntity(CreateBrandRequest request) {
        return new Brand(
                request.getBrand()
        );
    }
}