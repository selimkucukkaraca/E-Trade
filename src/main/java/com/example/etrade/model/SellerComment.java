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
public class SellerComment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String body;
    private int star;
    @ManyToOne
    private Seller seller;
    @ManyToOne
    private User user;
    private String sellerCommentId = UUID.randomUUID().toString();

    public SellerComment(String title, String body, int star,Seller seller,User user) {
        this.title = title;
        this.body = body;
        this.star = star;
        this.seller = seller;
        this.user = user;
    }
}