package com.example.etrade.dto.converter;

import com.example.etrade.TestUtil;
import com.example.etrade.dto.BrandDto;
import com.example.etrade.dto.request.CreateBrandRequest;
import com.example.etrade.model.Brand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BrandConverterTest extends TestUtil {

    private BrandConverter brandConverter;

    @BeforeEach
    public void setUp(){
        brandConverter = mock(BrandConverter.class);
    }

    @Test
    public void convertToDto_itShouldReturnBrandDto(){
        Brand brand = getBrandList().get(0);
        BrandDto brandDto = getBrandDtoList().get(0);

        when(brandConverter.convertToDto(brand)).thenReturn(brandDto);

        BrandDto response = brandConverter.convertToDto(brand);

        assertEquals(response,brandDto);
    }

    @Test
    public void toEntity_itShouldReturnBrand(){
        CreateBrandRequest request = getCreateBrandRequest();
        Brand brand = getBrandList().get(0);

        when(brandConverter.toEntity(request)).thenReturn(brand);

        Brand response = brandConverter.toEntity(request);

        assertEquals(brand,response);

    }
}