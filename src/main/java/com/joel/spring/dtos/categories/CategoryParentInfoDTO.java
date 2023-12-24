package com.joel.spring.dtos.categories;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CategoryParentInfoDTO {
    private String id;
    private String name;
    private Integer categoryOrder;
    private List<CategoryInfoDTO> children;
}
