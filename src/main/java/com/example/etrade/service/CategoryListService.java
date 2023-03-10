package com.example.etrade.service;

import com.example.etrade.dto.converter.CategoryConverter;
import com.example.etrade.model.Category;
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

    public Category getCategoryByCategoryName(String categoryName){
        return categoryRepository.getCategoryByCategoryName(categoryName);
    }
}
