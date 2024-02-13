package com.joel.spring.product.dto;

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
    private List<CategoryParentInfoDTO> categories;

    public ProductInfoDTO(String id, String name, String brand, Double price, Long stock) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.stock = stock;
    }
}
