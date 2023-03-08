package com.example.etrade.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@MappedSuperclass
public abstract class BaseEntity {
    private LocalDateTime createDate = LocalDateTime.now();
    private LocalDateTime updateDate;
}
