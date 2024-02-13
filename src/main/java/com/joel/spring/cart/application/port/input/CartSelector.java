package com.joel.spring.cart.application.port.input;

import com.joel.spring.cart.domain.Cart;

public interface CartSelector <T>{
    Cart get(T t);
}
