package com.example.etrade.controller;

import com.example.etrade.dto.request.ConfirmCartRequest;
import com.example.etrade.service.BuyProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/buy-product")
@CrossOrigin
public class BuyProductController {

    private final BuyProductService buyProductService;

    public BuyProductController(BuyProductService buyProductService) {
        this.buyProductService = buyProductService;
    }

    @PostMapping
    public ResponseEntity<Void> buy(@RequestBody ConfirmCartRequest request){
        buyProductService.buy(request);
        return ResponseEntity.noContent().build();
    }


}