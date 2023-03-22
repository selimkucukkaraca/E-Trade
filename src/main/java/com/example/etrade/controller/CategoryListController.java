package com.example.etrade.controller;

import com.example.etrade.dto.CategoryDto;
import com.example.etrade.service.CategoryListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category-list")
@CrossOrigin
public class CategoryListController {

    private final CategoryListService categoryListService;

    public CategoryListController(CategoryListService categoryListService) {
        this.categoryListService = categoryListService;
    }

    @GetMapping("/{categoryName}")
    public ResponseEntity<CategoryDto> getCategoryByCategoryName(@PathVariable String categoryName) {
        return ResponseEntity
                .ok(categoryListService.getCategoryByCategoryName(categoryName));

    }
}