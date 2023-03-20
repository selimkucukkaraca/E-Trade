package com.example.etrade.service;

import com.example.etrade.dto.CategoryDto;
import com.example.etrade.dto.converter.CategoryConverter;
import com.example.etrade.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryListService {

    private final CategoryRepository categoryRepository;
    private final CategoryConverter categoryConverter;

    public CategoryListService(CategoryRepository categoryRepository, CategoryConverter categoryConverter) {
        this.categoryRepository = categoryRepository;
        this.categoryConverter = categoryConverter;
    }

    public CategoryDto getCategoryByCategoryName(String categoryName){
        return categoryConverter.convertToDto(categoryRepository.findCategoryByCategoryName(categoryName));
    }
}