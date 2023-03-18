package com.example.etrade.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;;

@Data
@AllArgsConstructor
public class CreatePromoCodeRequest {

    private String userMail;
    private String code;
    private double amount;
    private LocalDate endDate;
}
