package com.example.etrade.dto.converter;

import com.example.etrade.TestUtil;
import com.example.etrade.dto.SubCategoryDto;
import com.example.etrade.dto.request.CreateSubCategoryRequest;
import com.example.etrade.model.SubCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SubCategoryConverterTest extends TestUtil {

    private SubCategoryConverter subCategoryConverter;

    @BeforeEach
    public void setUp() {
        subCategoryConverter = mock(SubCategoryConverter.class);
    }

    @Test
    public void convertToDto_itShouldReturnSubCategoryDto() {
        SubCategory subCategory = getSubCategoryList().get(0);
        SubCategoryDto subCategoryDto = getSubCategoryDtoList().get(0);

        when(subCategoryConverter.convertToDto(subCategory)).thenReturn(subCategoryDto);

        SubCategoryDto response = subCategoryConverter.convertToDto(subCategory);

        assertEquals(subCategoryDto, response);
    }

    @Test
    public void toEntity_itShouldReturnSubCategory() {
        CreateSubCategoryRequest request = getCreateSubCategoryRequest();
        SubCategory subCategory = getSubCategoryList().get(0);

        when(subCategoryConverter.toEntity(request)).thenReturn(subCategory);

        SubCategory response = subCategoryConverter.toEntity(request);

        assertEquals(subCategory,response);
    }
}