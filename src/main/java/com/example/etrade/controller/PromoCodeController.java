package com.example.etrade.controller;

import com.example.etrade.dto.PromoCodeDto;
import com.example.etrade.dto.request.CreatePromoCodeRequest;
import com.example.etrade.service.PromoCodeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/promo-code")
@CrossOrigin
public class PromoCodeController {

    private final PromoCodeService promoCodeService;

    public PromoCodeController(PromoCodeService promoCodeService) {
        this.promoCodeService = promoCodeService;
    }

    @PostMapping
    public ResponseEntity<PromoCodeDto> save(@RequestBody CreatePromoCodeRequest request) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(promoCodeService.save(request));
    }
}