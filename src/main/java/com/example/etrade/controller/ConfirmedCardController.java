package com.example.etrade.controller;

import com.example.etrade.service.ConfirmedCardService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/confirmed-card")
@CrossOrigin
public class ConfirmedCardController {

    private final ConfirmedCardService confirmedCardService;

    public ConfirmedCardController(ConfirmedCardService confirmedCardService) {
        this.confirmedCardService = confirmedCardService;
    }
}
