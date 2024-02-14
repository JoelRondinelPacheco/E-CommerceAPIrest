package com.joel.spring.cart.application.port.output;

import com.joel.spring.cartproduct.application.dto.AddProductToCartDTO;

public interface CartServicePort {

    void addProduct(AddProductToCartDTO info);
}
