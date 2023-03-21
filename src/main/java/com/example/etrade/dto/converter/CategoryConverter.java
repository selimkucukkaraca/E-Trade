package com.example.etrade.dto.converter;

import com.example.etrade.dto.CategoryDto;
import com.example.etrade.dto.SubCategoryDto;
import com.example.etrade.dto.request.CreateCategoryRequest;
import com.example.etrade.model.Category;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryConverter {

    public CategoryDto convertToDto(Category from){
        return new CategoryDto(
                from.getCategoryName()
        );
    }

    public Category toEntity(CreateCategoryRequest request){
        return new Category(
                request.getCategoryName()
        );
    }
}