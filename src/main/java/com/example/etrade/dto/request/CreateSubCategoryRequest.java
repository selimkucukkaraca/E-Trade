package com.example.etrade.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateSubCategoryRequest {

    private String categoryName;
    private String subCategoryName;

}