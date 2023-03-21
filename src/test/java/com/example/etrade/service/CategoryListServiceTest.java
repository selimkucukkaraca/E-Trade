package com.example.etrade.service;

import com.example.etrade.TestUtil;
import com.example.etrade.dto.CategoryDto;
import com.example.etrade.dto.converter.CategoryConverter;
import com.example.etrade.model.Category;
import com.example.etrade.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoryListServiceTest extends TestUtil {

    private CategoryRepository categoryRepository;
    private CategoryConverter categoryConverter;
    private CategoryListService categoryListService;

    @BeforeEach
    public void setUp(){
        categoryRepository = mock(CategoryRepository.class);
        categoryConverter = mock(CategoryConverter.class);
        categoryListService = new CategoryListService(categoryRepository,categoryConverter);
    }

    @Test
    public void getCategoryByCategoryName_itShouldReturnCategoryDto(){
        CategoryDto categoryDto = getCategoryDtoList().get(0);
        Category category = getCategoryList().get(0);
        String categoryName = "test";

        when(categoryConverter.convertToDto(category)).thenReturn(categoryDto);
        when(categoryRepository.findCategoryByCategoryName(categoryName)).thenReturn(category);

        CategoryDto response = categoryListService.getCategoryByCategoryName(categoryName);

        assertEquals(response,categoryDto);
        verify(categoryConverter).convertToDto(category);
        verify(categoryRepository).findCategoryByCategoryName(categoryName);
    }

}