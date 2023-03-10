package com.example.etrade.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Entity
public class ConfirmedCart extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Cart carts;
    private String confirmedId = UUID.randomUUID().toString();
    @ManyToOne
    private User user;

    public ConfirmedCart(Cart carts, User user) {
        this.carts = carts;
        this.user = user;
    }
}
