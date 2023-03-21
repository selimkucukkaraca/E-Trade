package com.example.etrade.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class AddressDto extends BaseDto{

    private String city;
    private String district;
    private String street;
    private String apartmentNumber;
    private String phoneNumber;
}