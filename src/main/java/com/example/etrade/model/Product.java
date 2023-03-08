package com.example.etrade.model;

import jakarta.persistence.*;
import lombok.*;

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
    private String productBrand;
    private String productDetails;
    private double productPrice;
    private boolean stock;
    private String productImageUrl;
    @ManyToOne
    private Seller seller;
    @ManyToOne
    private Category category;

    public Product(String productName, String productBrand, String productDetails,
                   double productPrice,String productImageUrl) {
        this.productName = productName;
        this.productBrand = productBrand;
        this.productDetails = productDetails;
        this.productPrice = productPrice;
        this.productImageUrl = productImageUrl;
    }
}