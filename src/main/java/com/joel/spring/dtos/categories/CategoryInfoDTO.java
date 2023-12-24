package com.joel.spring.dtos.categories;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CategoryInfoDTO {
    private String id;
    private String name;
    private Integer categoryOrder;
}
