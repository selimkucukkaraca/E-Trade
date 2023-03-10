package com.example.etrade.repository;

import com.example.etrade.model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryRepository extends JpaRepository<SubCategory,Long> {

    void deleteBySubCategoryName (String subCategoryName);

}
