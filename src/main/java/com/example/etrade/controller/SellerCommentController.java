package com.example.etrade.controller;

import com.example.etrade.dto.SellerCommentDto;
import com.example.etrade.dto.request.CreateSellerCommentRequest;
import com.example.etrade.service.SellerCommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/seller-comment")
@CrossOrigin
public class SellerCommentController {

    private final SellerCommentService sellerCommentService;

    public SellerCommentController(SellerCommentService sellerCommentService) {
        this.sellerCommentService = sellerCommentService;
    }

    @PostMapping
    public ResponseEntity<SellerCommentDto> save(@RequestBody CreateSellerCommentRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(sellerCommentService.save(request));
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestParam String sellerCommentId) {
        sellerCommentService.delete(sellerCommentId);
        return ResponseEntity
                .noContent()
                .build();
    }

    @GetMapping("/{sellerCommentId}")
    public ResponseEntity<SellerCommentDto> getSellerBySellerCommentId(@PathVariable String sellerCommentId) {
        return ResponseEntity
                .ok(sellerCommentService.getSellerBySellerCommentId(sellerCommentId));
    }
}