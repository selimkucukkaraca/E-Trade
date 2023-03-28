package com.example.etrade.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class CategoryDto extends BaseDto implements Serializable {

    private String categoryName;

}