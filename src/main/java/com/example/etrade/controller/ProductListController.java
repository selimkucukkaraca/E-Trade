package com.example.etrade.controller;

import com.example.etrade.dto.ProductDto;
import com.example.etrade.service.ProductListService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product-list")
@CrossOrigin
public class ProductListController {

    private final ProductListService productListService;

    public ProductListController(ProductListService productListService) {
        this.productListService = productListService;
    }

    @GetMapping("/{productName}")
    public ResponseEntity<List<ProductDto>> getProductByProductName(@PathVariable String productName){
        return ResponseEntity
                .ok(productListService.getProductByProductName(productName));
    }

    @GetMapping("/{brand}")
    public ResponseEntity<List<ProductDto>> getProductByProductBrand(@PathVariable String brand){
        return ResponseEntity
                .ok(productListService.getProductByProductBrand(brand));
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProductByProductPrice(@RequestParam double min,@RequestParam double max){
        return ResponseEntity
                .ok(productListService.getProductByProductPrice(min,max));
    }

    @GetMapping("/{stock}")
    public ResponseEntity<List<ProductDto>> getProductByProductStock(@PathVariable int stock){
        return ResponseEntity
                .ok(productListService.getProductByProductStock(stock));
    }

}