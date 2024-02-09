package com.joel.spring.category.domain;

import com.joel.spring.product.domain.Product;

import java.util.List;

public class Category {
    private String id;
    private String name;
    private String description;
    private Category parent;
    private List<Category> children;
    private List<Product> products;
}
