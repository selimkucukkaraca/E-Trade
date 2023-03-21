package com.example.etrade.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class PromoCodeDto {

    private String publicId;
    private String code;
    private double amount;
    private String codeText;
    private LocalDate endDate;
    private UserDto userDto;
}
