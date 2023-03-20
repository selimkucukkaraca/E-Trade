package com.example.etrade.repository;

import com.example.etrade.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category,Long> {

    Category findCategoryByCategoryName(String categoryName);
    boolean existsCategoryByCategoryName(String categoryName);
}