package com.example.etrade.repository;

import com.example.etrade.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {

    SubCategory findSubCategoryBySubCategoryName(String subCategoryName);

    boolean existsSubCategoryBySubCategoryName(String subCategoryName);

}