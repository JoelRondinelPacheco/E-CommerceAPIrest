package com.joel.spring.category.adapter.output.persistence.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity(name = "sub_category")
@Data
@Builder
public class SubCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity parent;

}
