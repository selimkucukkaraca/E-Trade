package com.example.etrade.dto.converter;

import com.example.etrade.TestUtil;
import com.example.etrade.dto.CategoryDto;
import com.example.etrade.dto.request.CreateCategoryRequest;
import com.example.etrade.model.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CategoryConverterTest extends TestUtil {

    private SubCategoryConverter subCategoryConverter;
    private CategoryConverter categoryConverter;

    @BeforeEach
    public void setUp(){
        subCategoryConverter = mock(SubCategoryConverter.class);
        categoryConverter = mock(CategoryConverter.class);
    }

    @Test
    public void convertToDto_itShouldReturnCategoryDto(){
        Category category = getCategoryList().get(0);
        CategoryDto categoryDto = getCategoryDtoList().get(0);

        when(categoryConverter.convertToDto(category)).thenReturn(categoryDto);

        CategoryDto response = categoryConverter.convertToDto(category);

        assertEquals(categoryDto,response);
    }

    @Test
    public void toEntity_itShouldReturnCategory(){
        CreateCategoryRequest request = getCreateCategoryRequest();
        Category category = getCategoryList().get(0);

        when(categoryConverter.toEntity(request)).thenReturn(category);

        Category response = categoryConverter.toEntity(request);

        assertEquals(category,response);
    }

}
