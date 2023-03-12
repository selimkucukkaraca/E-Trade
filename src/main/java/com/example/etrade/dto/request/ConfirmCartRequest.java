package com.example.etrade.dto.request;

import lombok.Data;

@Data
public class ConfirmCartRequest {

    private String cardNumber;
    private int cvv;
    private String expirationDate;
    private String nameAndSurname;
    private String cartId;
    private String userMail;
    private CreateAddressRequest address;
}