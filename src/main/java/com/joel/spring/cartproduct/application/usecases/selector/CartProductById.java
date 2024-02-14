package com.joel.spring.cartproduct.application.usecases.selector;

import com.joel.spring.cart.domain.Cart;
import com.joel.spring.cartproduct.application.port.output.CartProductSelector;
import com.joel.spring.cartproduct.domain.CartProduct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("cartProductById")
public class CartProductById implements CartProductSelector<CartProduct, String> {
    @Override
    public CartProduct get(String s) {
        return null;
    }
}
