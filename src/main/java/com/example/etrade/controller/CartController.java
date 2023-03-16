package com.example.etrade.controller;

import com.example.etrade.dto.CartDto;

import com.example.etrade.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
@CrossOrigin
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping
    public ResponseEntity<CartDto> save(@RequestParam String mail, @RequestParam String productId){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(cartService.save(mail,productId));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteByCartId(@RequestParam String cartId){
        cartService.deleteByCartId(cartId);
        return ResponseEntity
                .noContent()
                .build();
    }
}