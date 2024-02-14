package com.joel.spring.cart.domain;

import com.joel.spring.cartproduct.domain.CartProduct;

import java.util.List;

public class Cart {
    private String id;
    private Double totalPrice;
    private List<CartProduct> products;

    public Cart() {
        this.totalPrice = 0D;
    }
}
