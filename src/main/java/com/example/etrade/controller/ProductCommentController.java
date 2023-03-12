package com.example.etrade.controller;

import com.example.etrade.dto.ProductCommentDto;
import com.example.etrade.dto.request.CreateProductCommentRequest;
import com.example.etrade.service.ProductCommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product-comment")
@CrossOrigin
public class ProductCommentController {

    private final ProductCommentService productCommentService;

    public ProductCommentController(ProductCommentService productCommentService) {
        this.productCommentService = productCommentService;
    }

    @PostMapping
    public ResponseEntity<ProductCommentDto> save(CreateProductCommentRequest request){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productCommentService.save(request));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam String productCommentId){
        productCommentService.delete(productCommentId);
        return ResponseEntity
                .noContent()
                .build();
    }

    @GetMapping("/{productCommentId}")
    public ResponseEntity<ProductCommentDto> getByProductId(@PathVariable String productCommentId){
        return ResponseEntity
                .ok(productCommentService.getByProductCommentId(productCommentId));
    }
}
