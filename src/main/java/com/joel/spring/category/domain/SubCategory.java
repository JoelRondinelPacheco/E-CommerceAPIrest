package com.joel.spring.category.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubCategory {
    private Long id;
    private String name;
    private Category parent;
}
