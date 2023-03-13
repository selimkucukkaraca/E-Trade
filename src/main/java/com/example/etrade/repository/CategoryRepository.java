package com.example.etrade.repository;

import com.example.etrade.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category,Long> {

    void deleteByCategoryName(String categoryName);
    Category getCategoryByCategoryName(String categoryName);

}