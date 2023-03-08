package com.example.etrade.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CategoryDto extends BaseDto{

    private String categoryName;
    private List<SubCategoryDto> subCategoryDtoList;

}
