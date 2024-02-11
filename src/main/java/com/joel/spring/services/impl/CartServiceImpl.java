package com.joel.spring.services.impl;

import com.joel.spring.dtos.cart.AddProductToCartDTO;
import com.joel.spring.dtos.cart.ProductInfoDTO;
import com.joel.spring.cart.adapter.out.persistence.entity.CartEntity;
import com.joel.spring.entities.CartProductEntity;
import com.joel.spring.exceptions.NotFoundException;
import com.joel.spring.repositories.CartRepository;
import com.joel.spring.services.CartService;
import com.joel.spring.user.application.port.input.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService {

    @Autowired private UserService userService;
    @Autowired private CartRepository cartRepository;


    @Override
    public void saveByEntity(CartEntity cartEntity) {
        this.cartRepository.save(cartEntity);
    }

    @Override
    public String addProduct(AddProductToCartDTO body, String id) {
        /*if (this.userService.existsById(id)) {
        }*/
        return null;
    }

    @Override
    public CartEntity findById(String id) throws NotFoundException {
        return this.checkCartOptional(this.cartRepository.findById(id));
    }

    @Override
    public CartEntity findByUserId(String userId) throws NotFoundException {
        return this.checkCartOptional(this.cartRepository.findByUser_Id(userId));
    }

    @Override
    public List<ProductInfoDTO> getUserCard(String id) throws NotFoundException {
        CartEntity cartEntity = this.findByUserId(id);
        List<ProductInfoDTO> response = new ArrayList<>();
        for (CartProductEntity cartProductEntity : cartEntity.getProducts()) {
            response.add(
                    ProductInfoDTO.builder()
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
