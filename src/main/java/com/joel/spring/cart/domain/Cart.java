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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<CartProduct> getProducts() {
        return products;
    }

    public void setProducts(List<CartProduct> products) {
        this.products = products;
    }
}
