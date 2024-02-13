package com.joel.spring.cart.application.port.input;

public interface CartProductsService {
    String add(String productId);
    String delete(String productId);
    String editQuantity(Long quantity);
}
