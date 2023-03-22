package com.example.etrade.repository;

import com.example.etrade.model.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductCommentRepository extends JpaRepository<ProductComment, Long> {

    Optional<ProductComment> findProductCommentByProductCommentId(String productCommentId);

}