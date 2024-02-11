package com.joel.spring.cart.adapter.out.persistence;

import com.joel.spring.cart.adapter.out.persistence.entity.CartEntity;
import com.joel.spring.cart.adapter.out.persistence.repository.MySQLCartRepository;
import com.joel.spring.cart.application.port.output.CreateCartPort;
import com.joel.spring.cart.domain.Cart;
import com.joel.spring.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CartPersistenceAdapter implements CreateCartPort {

    @Autowired
    private MySQLCartRepository cartRepository;
    @Autowired
    @Qualifier("cartMapper")
    private Mapper<CartEntity, Cart> cartMapper;

    @Override
    public Cart create(Cart cart) {

        return null;
    }
}
