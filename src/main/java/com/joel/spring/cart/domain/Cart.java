package com.joel.spring.cart.domain;

import com.joel.spring.product.domain.Product;
import com.joel.spring.user.domain.User;

import java.util.List;

public class Cart {
    private String id;
    private Double totalPrice;
    private List<Product> products;
    private User user;
}
