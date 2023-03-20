package com.example.etrade.service;

import com.example.etrade.TestUtil;
import com.example.etrade.dto.CategoryDto;
import com.example.etrade.dto.converter.CategoryConverter;
import com.example.etrade.dto.request.CreateCategoryRequest;
import com.example.etrade.model.Category;
import com.example.etrade.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoryServiceTest extends TestUtil {

    private CategoryRepository categoryRepository;
    private CategoryConverter categoryConverter;
    private CategoryService categoryService;

    @BeforeEach
    public void setUp(){
        categoryRepository = mock(CategoryRepository.class);
        categoryConverter = mock(CategoryConverter.class);
        categoryService = new CategoryService(categoryRepository,categoryConverter);
    }

    @Test
    public void saveCategory_itShouldReturnCategoryDto(){
        CreateCategoryRequest request = getCreateCategoryRequest();
        Category category = getCategoryList().get(0);
        CategoryDto categoryDto = getCategoryDtoList().get(0);

        when(categoryConverter.toEntity(request)).thenReturn(category);
        when(categoryRepository.save(category)).thenReturn(category);
        when(categoryConverter.convertToDto(category)).thenReturn(categoryDto);
        when(categoryRepository.existsCategoryByCategoryName("test"));

        CategoryDto response = categoryService.save(request);

        assertEquals(response,categoryDto);

        verify(categoryConverter).toEntity(request);
        verify(categoryRepository).save(category);
        verify(categoryConverter).convertToDto(category);
        verify(categoryRepository).existsCategoryByCategoryName("test");
    }

    @Test
    public void getByCategoryName_itShouldReturnCategory(){
        Category category = getCategoryList().get(0);
        String categoryName = "test";

        when(categoryRepository.findCategoryByCategoryName(categoryName)).thenReturn(category);

        Category response = categoryService.getByCategoryName(categoryName);

        assertEquals(response,category);
        verify(categoryRepository).findCategoryByCategoryName(categoryName);
    }

    @Test
    public void delete(){
        Category category = getCategoryList().get(0);
        String categoryName = "Test";

        when(categoryRepository.findCategoryByCategoryName(categoryName)).thenReturn(category);

        categoryService.deleteCategory(categoryName);

        verify(categoryRepository).delete(category);
    }

    @Test
    public void updateCategory(){
        Category category = getCategoryList().get(0);

        when(categoryRepository.save(category)).thenReturn(category);

        categoryService.updateCategory(category);

        verify(categoryRepository).save(category);
    }

}