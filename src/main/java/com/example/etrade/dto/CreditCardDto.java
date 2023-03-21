package com.example.etrade.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class CreditCardDto extends BaseDto {

    private String cardNumber;
    private int cvv;
    private String expirationDate;
    private String nameAndSurname;
}
