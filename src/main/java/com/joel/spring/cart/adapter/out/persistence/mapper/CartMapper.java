package com.joel.spring.cart.adapter.out.persistence.mapper;

import com.joel.spring.cart.adapter.out.persistence.entity.CartEntity;
import com.joel.spring.cart.domain.Cart;
import com.joel.spring.utils.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("cartMapper")
public class CartMapper implements Mapper<CartEntity, Cart> {

    @Override
    public Cart entityToDomain(CartEntity cartEntity) {
        return null;
    }

    @Override
    public CartEntity domainToEntity(Cart cart) {
        CartEntity cartEntity = new CartEntity();
        cartEntity.setTotalPrice(cart.getTotalPrice());
        return cartEntity;

    }
}
