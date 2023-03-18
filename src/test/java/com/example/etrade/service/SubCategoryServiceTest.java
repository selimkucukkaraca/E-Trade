package com.example.etrade.service;

import com.example.etrade.TestUtil;
import com.example.etrade.dto.SubCategoryDto;
import com.example.etrade.dto.converter.CategoryConverter;
import com.example.etrade.dto.converter.SubCategoryConverter;
import com.example.etrade.dto.request.CreateSubCategoryRequest;
import com.example.etrade.model.Category;
import com.example.etrade.model.SubCategory;
import com.example.etrade.repository.CategoryRepository;
import com.example.etrade.repository.SubCategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SubCategoryServiceTest extends TestUtil {

    private SubCategoryRepository subCategoryRepository;
    private SubCategoryConverter subCategoryConverter;
    private CategoryService categoryService;
    private SubCategoryService subCategoryService;
    private CategoryRepository categoryRepository;

    @BeforeEach
    public void setUp(){
        subCategoryRepository = mock(SubCategoryRepository.class);
        subCategoryConverter = mock(SubCategoryConverter.class);
        categoryService = mock(CategoryService.class);
        subCategoryService = new SubCategoryService(subCategoryRepository,subCategoryConverter,categoryService);
        categoryRepository = mock(CategoryRepository.class);
        CategoryConverter categoryConverter = mock(CategoryConverter.class);
        categoryService = new CategoryService(categoryRepository, categoryConverter);
    }

/*    @Test
    public void saveSubCategory_itShouldReturnSubCategoryDto(){
        CreateSubCategoryRequest request = getCreateSubCategoryRequest();
        SubCategory subCategory = getSubCategoryList().get(0);
        SubCategoryDto subCategoryDto = getSubCategoryDtoList().get(0);
        Category category = getCategoryList().get(0);

        //getbycaTEgory name i yaz
        when(categoryRepository.getCategoryByCategoryName("test")).thenReturn(category);
        when(categoryService.getByCategoryName("test")).thenReturn(category);
        when(subCategoryConverter.toEntity(request)).thenReturn(subCategory);
        when(subCategoryRepository.existsSubCategoryBySubCategoryName("test")).thenReturn(false);
        category.getSubCategories().add(subCategory);
        when(subCategoryRepository.save(subCategory)).thenReturn(subCategory);
        when(categoryRepository.save(category));

        //
        when(subCategoryConverter.convertToDto(subCategory)).thenReturn(subCategoryDto);

        SubCategoryDto response = subCategoryService.save(request);

        assertEquals(response,subCategoryDto);
        //
        verify(subCategoryConverter).toEntity(request);
        verify(subCategoryRepository).existsSubCategoryBySubCategoryName("test");
        //
        verify(subCategoryRepository).save(subCategory);

    }*/

    @Test
    public void delete(){



    }
}