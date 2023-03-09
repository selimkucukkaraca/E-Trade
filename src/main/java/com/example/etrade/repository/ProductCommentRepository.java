package com.example.etrade.repository;

import com.example.etrade.model.ProductComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCommentRepository extends JpaRepository<ProductComment,Long> {
}
