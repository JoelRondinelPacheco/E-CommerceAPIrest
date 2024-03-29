package com.joel.spring.category.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CategoryInfoDTO {
    private String id;
    private String name;
    private Integer categoryOrder;
    private List<String> subCategories;
}
