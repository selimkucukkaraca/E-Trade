package com.example.etrade.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CreditCard extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cardNumber;
    private int cvv;
    private String expirationDate;
    private String nameAndSurname;
    @ManyToOne
    private User user;

    public CreditCard(String cardNumber, int cvv, String expirationDate, String nameAndSurname) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expirationDate = expirationDate;
        this.nameAndSurname = nameAndSurname;
    }
}