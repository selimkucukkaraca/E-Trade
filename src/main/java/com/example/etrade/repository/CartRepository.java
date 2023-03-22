package com.example.etrade.repository;

import com.example.etrade.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

    Cart findCartByCartId(String cartId);

}