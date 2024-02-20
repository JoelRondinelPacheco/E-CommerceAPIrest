package com.joel.spring.category.application.dto;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class NewCategoryDTO {
    private String name;
    private String description;
    private List<NewSubCategory> subCategories;
}
