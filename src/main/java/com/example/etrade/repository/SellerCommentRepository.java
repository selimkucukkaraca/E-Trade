package com.example.etrade.repository;

import com.example.etrade.model.SellerComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SellerCommentRepository extends JpaRepository<SellerComment, Long> {

    Optional<SellerComment> findSellerCommentBySellerCommentId(String sellerCommentId);

}