package com.joel.spring.cart.application.port.input;

import com.joel.spring.cart.domain.Cart;

public interface FindCartBy {
    Cart id(String id);

    Cart usersId(String id);

    Cart userEmail(String email);
}
