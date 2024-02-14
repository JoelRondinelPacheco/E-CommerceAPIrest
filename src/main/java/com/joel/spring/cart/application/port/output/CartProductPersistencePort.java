package com.joel.spring.cart.application.port.output;

import com.joel.spring.cartproduct.domain.CartProduct;

public interface CartProductPersistencePort {
    CartProduct create(CartProduct cartProduct);
    //TODO SEND RESPONSE???
    void delete(String cartProductId);
}
