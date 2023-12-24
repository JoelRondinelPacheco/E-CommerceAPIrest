package com.joel.spring.dtos.products;

import com.joel.spring.dtos.categories.CategoryParentInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductInfoDTO {
    private String id;
    private String name;
    private String brand;
    private Double price;
    private Long stock;
    private CategoryParentInfoDTO category;
}
