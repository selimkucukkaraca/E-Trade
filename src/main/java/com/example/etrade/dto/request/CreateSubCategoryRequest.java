package com.example.etrade.dto.request;

import lombok.Data;

@Data
public class CreateSubCategoryRequest {

    private String categoryName;
    private String subCategoryName;

}