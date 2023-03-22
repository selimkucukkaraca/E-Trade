package com.example.etrade.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cart extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    @ToString.Exclude
    private List<Product> product;
    @ManyToOne
    private User user;
    private String cartId = UUID.randomUUID().toString();

    public Cart(List<Product> product, User user) {
        this.product = product;
        this.user = user;
    }
}