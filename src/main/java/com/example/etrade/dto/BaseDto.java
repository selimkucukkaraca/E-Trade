package com.example.etrade.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@MappedSuperclass
public abstract class BaseDto {

    private LocalDateTime createDate = LocalDateTime.now();
    private LocalDateTime updateDate;

}