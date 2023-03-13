package com.example.etrade.dto.converter;

import com.example.etrade.dto.CategoryDto;
import com.example.etrade.dto.SubCategoryDto;
import com.example.etrade.dto.request.CreateCategoryRequest;
import com.example.etrade.model.Category;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoryConverter {

    private final SubCategoryConverter subCategoryConverter;

    public CategoryConverter(SubCategoryConverter subCategoryConverter) {
        this.subCategoryConverter = subCategoryConverter;
    }

    public CategoryDto convertToDto(Category from){
        List<SubCategoryDto> subCategoryDtoList = from.getSubCategories()
                .stream()
                .map(subCategoryConverter::convertToDto).toList();

        return new CategoryDto(
                from.getCategoryName(),
                subCategoryDtoList
        );
    }

    public Category toEntity(CreateCategoryRequest request){
        return new Category(
                request.getCategoryName()
        );
    }
}