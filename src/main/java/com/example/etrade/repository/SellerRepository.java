package com.example.etrade.repository;

import com.example.etrade.model.Seller;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SellerRepository extends JpaRepository<Seller, Long> {

    Optional<Seller> findSellerByMail(String mail);

    boolean existsSellerByMail(String mail);
}