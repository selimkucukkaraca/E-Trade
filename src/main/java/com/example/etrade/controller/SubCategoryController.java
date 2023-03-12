package com.example.etrade.controller;

import com.example.etrade.dto.SubCategoryDto;
import com.example.etrade.dto.request.CreateSubCategoryRequest;
import com.example.etrade.service.SubCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/sub-category")
@CrossOrigin
public class SubCategoryController {

    private final SubCategoryService subCategoryService;

    public SubCategoryController(SubCategoryService subCategoryService) {
        this.subCategoryService = subCategoryService;
    }

    @PostMapping
    public ResponseEntity<SubCategoryDto> save(@RequestBody CreateSubCategoryRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(subCategoryService.save(request));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam String subCategoryName){
        subCategoryService.delete(subCategoryName);
        return ResponseEntity
                .noContent()
                .build();
    }
}