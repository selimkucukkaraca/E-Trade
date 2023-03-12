package com.example.etrade.service;

import com.example.etrade.dto.SubCategoryDto;
import com.example.etrade.dto.converter.SubCategoryConverter;
import com.example.etrade.dto.request.CreateSubCategoryRequest;
import com.example.etrade.repository.SubCategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class SubCategoryService {

    private final SubCategoryRepository subCategoryRepository;
    private final SubCategoryConverter subCategoryConverter;
    private final CategoryService categoryService;

    public SubCategoryService(SubCategoryRepository subCategoryRepository,
                              SubCategoryConverter subCategoryConverter, CategoryService categoryService) {
        this.subCategoryRepository = subCategoryRepository;
        this.subCategoryConverter = subCategoryConverter;
        this.categoryService = categoryService;
    }

    public SubCategoryDto save(CreateSubCategoryRequest request){
        var category = categoryService.getByCategoryName(request.getCategoryName());
        var saved = subCategoryConverter.toEntity(request);

        subCategoryRepository.save(saved);
        category.getSubCategories().add(saved);
        categoryService.updateCategory(category);
        return subCategoryConverter.convert(saved);
    }

    public void delete(String subCategoryName){
        subCategoryRepository.deleteBySubCategoryName(subCategoryName);
    }
}
