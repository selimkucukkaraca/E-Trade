package com.example.etrade.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class CreateCategoryRequest {
    @NotBlank
    private String categoryName;

}
