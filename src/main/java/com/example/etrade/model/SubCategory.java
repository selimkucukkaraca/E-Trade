package com.example.etrade.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SubCategory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String subCategoryName;

    public SubCategory(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }
}