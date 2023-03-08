package com.example.etrade.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cart extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double quantity;
    private String productName;
    private String productDetails;
    private double productPrice;
    private String productImageUrl;
    @ManyToOne
    private Seller seller;

    public Cart(double quantity, String productName, String productDetails,
                double productPrice, String productImageUrl) {
        this.quantity = quantity;
        this.productName = productName;
        this.productDetails = productDetails;
        this.productPrice = productPrice;
        this.productImageUrl = productImageUrl;
    }
}