package com.example.etrade.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String city;
    private String district;
    private String street;
    private String apartmentNumber;
    private String phoneNumber;
    private String addressId = UUID.randomUUID().toString();

    public Address(String city, String district, String street,
                   String apartmentNumber, String phoneNumber ) {
        this.city = city;
        this.district = district;
        this.street = street;
        this.apartmentNumber = apartmentNumber;
        this.phoneNumber = phoneNumber;
    }
}
