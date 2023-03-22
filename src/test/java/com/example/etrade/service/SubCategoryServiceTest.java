package com.example.etrade.service;

import com.example.etrade.TestUtil;
import com.example.etrade.dto.converter.CategoryConverter;
import com.example.etrade.dto.converter.SubCategoryConverter;
import com.example.etrade.model.SubCategory;
import com.example.etrade.repository.CategoryRepository;
import com.example.etrade.repository.SubCategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class SubCategoryServiceTest extends TestUtil {

    private SubCategoryRepository subCategoryRepository;
    private SubCategoryConverter subCategoryConverter;
    private CategoryService categoryService;
    private SubCategoryService subCategoryService;
    private CategoryRepository categoryRepository;

    @BeforeEach
    public void setUp() {
        subCategoryRepository = mock(SubCategoryRepository.class);
        subCategoryConverter = mock(SubCategoryConverter.class);
        categoryService = mock(CategoryService.class);
        subCategoryService = new SubCategoryService(subCategoryRepository, subCategoryConverter, categoryService);
        categoryRepository = mock(CategoryRepository.class);
        CategoryConverter categoryConverter = mock(CategoryConverter.class);
        categoryService = new CategoryService(categoryRepository, categoryConverter);
    }


    @Test
    public void saveSubCategory_itShouldReturnSubCategoryDto() {
        //TODO
    }

    @Test
    public void delete() {

        SubCategory subCategory = getSubCategoryList().get(0);
        String subCategoryName = "test";

        when(subCategoryRepository.findSubCategoryBySubCategoryName(subCategoryName)).thenReturn(subCategory);

        subCategoryService.delete(subCategoryName);

        verify(subCategoryService).delete(subCategoryName);

    }
}