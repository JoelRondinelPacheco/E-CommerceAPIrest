package com.joel.spring.cart.domain;

import com.joel.spring.product.domain.Product;

public class CartProduct {
    private String id;
    private Integer quantity;
    private Product product;
    private Cart cart;
}
