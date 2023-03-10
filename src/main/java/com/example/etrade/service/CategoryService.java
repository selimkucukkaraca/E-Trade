package com.example.etrade.service;

import com.example.etrade.dto.CategoryDto;
import com.example.etrade.dto.converter.CategoryConverter;
import com.example.etrade.dto.request.CreateCategoryRequest;
import com.example.etrade.model.Category;
import com.example.etrade.repository.CategoryRepository;
import org.springframework.stereotype.Service;


@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryConverter categoryConverter;

    public CategoryService(CategoryRepository categoryRepository, CategoryConverter categoryConverter) {
        this.categoryRepository = categoryRepository;
        this.categoryConverter = categoryConverter;
    }

    public CategoryDto save(CreateCategoryRequest request){
        var saved = categoryConverter.toEntity(request);
        categoryRepository.save(saved);
        return categoryConverter.convert(saved);
    }

    public void deleteCategory(String categoryName){
        categoryRepository.deleteByCategoryName(categoryName);
    }

    protected Category getByCategoryName(String categoryName){
        return categoryRepository.getCategoryByCategoryName(categoryName);
    }

    protected void updateCategory(Category category){
        categoryRepository.save(category);
    }

}