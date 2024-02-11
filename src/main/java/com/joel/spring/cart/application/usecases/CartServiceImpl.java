package com.joel.spring.cart.application.usecases;

import com.joel.spring.cart.application.port.input.CartService;
import com.joel.spring.cart.application.port.output.CreateCartPort;
import com.joel.spring.cart.domain.Cart;
import com.joel.spring.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

public class CartServiceImpl implements CartService {

    @Autowired
    private CreateCartPort cartRepository;
    @Override
    public Cart createFor(User user) {
        Cart cart = new Cart(user);
        return this.cartRepository.create(new Cart(user));
    }
}
