package com.joel.spring.product.domain;

import com.joel.spring.cartproduct.domain.CartProduct;
import com.joel.spring.category.domain.Category;
import com.joel.spring.sales.domain.Sale;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Product {
    private String id;
    private LocalDate created;
    private String name;
    private String brand;
    private Double price;
    private Long stock;

    private List<Sale> sales;
    private List<Category> categories;
    private List<CartProduct> cartsProducts;
    private List<String> categoriesId;
}
