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
public class ProductComment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String body;
    private int star;
    @ManyToOne
    private Product product;
    private String productCommentId = UUID.randomUUID().toString();
    @ManyToOne
    private User user;

    public ProductComment(String title, String body, int star, User user, Product product) {
        this.title = title;
        this.body = body;
        this.star = star;
        this.user = user;
        this.product = product;
    }
}