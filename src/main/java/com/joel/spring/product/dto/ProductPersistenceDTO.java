package com.joel.spring.product.dto;

import com.joel.spring.product.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProductPersistenceDTO {
    private Product product;
    private List<String> categoriesId;


}
