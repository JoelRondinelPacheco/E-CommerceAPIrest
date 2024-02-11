package com.joel.spring.cart.application.port.output;

import com.joel.spring.cart.domain.Cart;

public interface CreateCartPort {
    Cart create(Cart cart);
}
