package com.example.etrade.controller;

import com.example.etrade.dto.ProductDto;
import com.example.etrade.dto.request.CreateProductRequest;
import com.example.etrade.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@CrossOrigin
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductDto>save(CreateProductRequest request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productService.save(request));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam String productId){
        productService.deleteByProductId(productId);
        return ResponseEntity
                .noContent()
                .build();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDto> getByProductId(@PathVariable String productId){
        return ResponseEntity
                .ok(productService.getByProductId(productId));
    }


}
