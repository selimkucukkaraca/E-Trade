package com.example.etrade.repository;

import com.example.etrade.model.ConfirmedCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmedCartRepository extends JpaRepository<ConfirmedCart, Long> {
}
