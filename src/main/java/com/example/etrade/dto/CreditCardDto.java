package com.example.etrade.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreditCardDto extends BaseDto {

    private String cardNumber;
    private int cvv;
    private String expirationDate;
    private String nameAndSurname;
}
