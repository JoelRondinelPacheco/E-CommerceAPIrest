package com.joel.spring.cartproduct.domain;

import com.joel.spring.cart.domain.Cart;
import com.joel.spring.product.domain.Product;
import lombok.Data;

@Data
public class CartProduct {
    private String id;
    private Integer quantity;
    private Double price;
    private Product product;
    private Cart cart;


    private CartProduct(Integer quantity, Double price, Product product, Cart cart) {
        this.quantity = quantity;
        this.price = price;
        this.product = product;
        this.cart = cart;
    }

    public static CartProduct NewCartProduct(Integer quantity, Product product, Cart cart) {
        return new CartProduct(quantity, quantity * product.getPrice(), product, cart);
    }
    public static CartProduct ExistingCartProduct(Integer quantity, Double price, Product product, Cart cart) {
        return new CartProduct(quantity, price, product, cart);
    }
}
