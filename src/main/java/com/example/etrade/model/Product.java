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
    private int stock;
    private String productImageUrl;
    @ManyToOne
    private Seller seller;
    @ManyToOne
    private Category category;
    private String productId = UUID.randomUUID().toString();
    @ManyToOne
    private Brand brand;

    public Product(String productName,String productDetails,
                   double productPrice,int stock, String productImageUrl,Category category,Brand brand) {
        this.productName = productName;
        this.productDetails = productDetails;
        this.productPrice = productPrice;
        this.stock = stock;
        this.productImageUrl = productImageUrl;
        this.category = category;
        this.brand = brand;
    }

    public Product(String productName) {
        this.productName = productName;
    }
}