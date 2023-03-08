package com.example.etrade.dto.request;

import lombok.Data;

@Data
public class CreateCreditCardRequest {

    private String cardNumber;
    private int cvv;
    private String expirationDate;
    private String nameAndSurname;
}
