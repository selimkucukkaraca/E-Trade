package com.example.etrade.dto.converter;

import com.example.etrade.dto.SubCategoryDto;
import com.example.etrade.dto.request.CreateSubCategoryRequest;
import com.example.etrade.model.SubCategory;
import org.springframework.stereotype.Component;

@Component
public class SubCategoryConverter {

    public SubCategoryDto convertToDto(SubCategory from) {
        return new SubCategoryDto(
                from.getSubCategoryName()
        );
    }

    public SubCategory toEntity(CreateSubCategoryRequest request) {
        return new SubCategory(
                request.getSubCategoryName()
        );
    }
}