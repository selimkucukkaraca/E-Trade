package com.example.etrade.dto.request;

import lombok.Data;

@Data
public class CreateAddressRequest {

    private String country;
    private String city;
    private String district;
    private String street;
    private String apartmentNumber;

}
