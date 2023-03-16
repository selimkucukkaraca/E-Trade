package com.example.etrade.controller;

import com.example.etrade.dto.ConfirmedCartDto;
import com.example.etrade.service.ConfirmedCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/confirmed-cart")
@CrossOrigin
public class ConfirmedCardController {

    private final ConfirmedCardService confirmedCardService;

    public ConfirmedCardController(ConfirmedCardService confirmedCardService) {
        this.confirmedCardService = confirmedCardService;
    }

    @GetMapping
    public ResponseEntity<List<ConfirmedCartDto>> getAll(@RequestParam int page, @RequestParam int size){
        return ResponseEntity
                .ok(confirmedCardService.getAll(page,size));
    }
}
