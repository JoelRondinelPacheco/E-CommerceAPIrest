package com.joel.spring.category.domain;

import com.joel.spring.product.domain.Product;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class Category {
    private String id;
    private String name;
    private String description;
    private List<SubCategory> subCategories;
    //TODO VERIFICAR SI ESTE ATRIBUTO DEBE IR
    private List<Product> products;


}
