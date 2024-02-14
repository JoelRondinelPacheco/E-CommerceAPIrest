package com.joel.spring.cart.application.usecases;

import com.joel.spring.cartproduct.adapter.output.persistence.CartProductEntity;
import com.joel.spring.cart.adapter.out.persistence.entity.CartEntity;
import com.joel.spring.cart.application.port.input.CartService;
import com.joel.spring.cart.domain.Cart;
import com.joel.spring.cartproduct.application.dto.ProductCartInfoDTO;
import com.joel.spring.exceptions.NotFoundException;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {


    @Override
    public Cart create() {
        Cart cart = new Cart();
        return null;
    }


    @Override
    public List<ProductCartInfoDTO> getUserCard(String id) throws NotFoundException {
       // CartEntity cartEntity = this.findByUserId(id);
        //TODO REFACTOR
        CartEntity cartEntity = new CartEntity();
        List<ProductCartInfoDTO> response = new ArrayList<>();
        for (CartProductEntity cartProductEntity : cartEntity.getProducts()) {
            response.add(
                    ProductCartInfoDTO.builder()
                            .cartProductId(cartProductEntity.getId())
                            .productId(cartProductEntity.getProduct().getId())
                            .name(cartProductEntity.getProduct().getName())
                            .brand(cartProductEntity.getProduct().getBrand())
                            .price(cartProductEntity.getProduct().getPrice())
                            .quantity(cartProductEntity.getQuantity())
                            .build());
        }
        return response;
    }

    private CartEntity checkCartOptional(Optional<CartEntity> cartOptional) throws NotFoundException {
        if (cartOptional.isPresent()) {
            return cartOptional.get();
        }
        throw new NotFoundException("CartEntity not found");
    }

}
