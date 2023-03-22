package com.example.etrade.controller;

import com.example.etrade.dto.CategoryDto;
import com.example.etrade.dto.request.CreateCategoryRequest;
import com.example.etrade.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
@CrossOrigin
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryDto> save(@RequestBody @Valid CreateCategoryRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(categoryService.save(request));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestParam String categoryName) {
        categoryService.deleteCategory(categoryName);
        return ResponseEntity
                .noContent()
                .build();
    }
}