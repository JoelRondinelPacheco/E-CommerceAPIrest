package com.joel.spring.cart.application.port.input;

import com.joel.spring.cart.domain.Cart;
import com.joel.spring.user.domain.User;

public interface CartService {
    Cart create(User user);
}
