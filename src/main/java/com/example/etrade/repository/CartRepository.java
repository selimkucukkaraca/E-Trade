package com.example.etrade.repository;

import com.example.etrade.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart,Long> {

    Cart findCartByCartId(String cartId);
    Optional<Cart> deleteByCartId(String cartId);
}
