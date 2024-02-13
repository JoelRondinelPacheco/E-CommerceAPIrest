package com.joel.spring.cart.application.usecases.selector;

import com.joel.spring.cart.application.port.input.CartSelector;
import com.joel.spring.cart.domain.Cart;

public class CartByUserId implements CartSelector<String> {
    @Override
    public Cart get(String s) {
        return null;
    }
}
