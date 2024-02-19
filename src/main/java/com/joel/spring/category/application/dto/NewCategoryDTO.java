package com.joel.spring.category.application.dto;

import lombok.Data;

import java.util.List;

@Data
public class NewCategoryDTO {
    private String name;
    private String description;
    private List<NewSubCategory> subCategories;
}
