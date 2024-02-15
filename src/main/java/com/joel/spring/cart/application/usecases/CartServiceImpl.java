package com.joel.spring.cart.application.usecases;

import com.joel.spring.cart.application.port.output.CartServicePort;
import com.joel.spring.cart.adapter.out.persistence.entity.CartEntity;
import com.joel.spring.cart.application.port.input.CartService;
import com.joel.spring.cart.domain.Cart;
import com.joel.spring.cartproduct.application.dto.ProductCartInfoDTO;
import com.joel.spring.cartproduct.application.port.input.CartProductSelector;
import com.joel.spring.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartServicePort cartRepository;
    @Autowired
    private CartProductSelector cartProductsSelector;

    @Override
    public Cart create() {
        Cart cart = new Cart();
        return cart;
    }

    @Override
    public Long cartProductsQuantity(String cartId) {
        return this.cartRepository.cartProductsQuantity(cartId);
    }


    @Override
    public List<ProductCartInfoDTO> getUserCard(String id) {
       return this.cartProductsSelector.byUserId(id);
    }

    private CartEntity checkCartOptional(Optional<CartEntity> cartOptional) throws NotFoundException {
        if (cartOptional.isPresent()) {
            return cartOptional.get();
        }
        throw new NotFoundException("CartEntity not found");
    }

}
