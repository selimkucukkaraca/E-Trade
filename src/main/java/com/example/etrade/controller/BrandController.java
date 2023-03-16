package com.example.etrade.controller;

import com.example.etrade.dto.BrandDto;
import com.example.etrade.dto.request.CreateBrandRequest;
import com.example.etrade.service.BrandService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/brand")
@CrossOrigin
public class BrandController {

    private final BrandService brandService;

    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @PostMapping
    public ResponseEntity<BrandDto> save(@RequestBody CreateBrandRequest request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(brandService.save(request));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam String brandId){
        brandService.deleteBrandByBrandId(brandId);
        return ResponseEntity
                .noContent()
                .build();
    }

}
