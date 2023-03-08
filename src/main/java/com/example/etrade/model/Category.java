package com.example.etrade.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String categoryName;
    @OneToMany
    @ToString.Exclude
    private List<SubCategory> subCategories;

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }
}