package com.example.etrade.model;

import jakarta.persistence.*;
import lombok.*;

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
    private String country;
    private String city;
    private String district;
    private String street;
    private String apartmentNumber;
    @ManyToOne
    private User user;

    public Address(String country, String city, String district, String street, String apartmentNumber) {
        this.country = country;
        this.city = city;
        this.district = district;
        this.street = street;
        this.apartmentNumber = apartmentNumber;
    }
}
