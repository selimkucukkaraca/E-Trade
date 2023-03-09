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
public class Product extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String productName;
    private String productDetails;
    private double productPrice;
    private boolean stock;
    private String productImageUrl;
    @ManyToOne
    private Seller seller;
    @ManyToOne
    private Category category;
    private String productId = UUID.randomUUID().toString();
    @ManyToOne
    private Brand brand;

    public Product(String productName,String productDetails,
                   double productPrice,String productImageUrl) {
        this.productName = productName;
        this.productDetails = productDetails;
        this.productPrice = productPrice;
        this.productImageUrl = productImageUrl;

    }
}