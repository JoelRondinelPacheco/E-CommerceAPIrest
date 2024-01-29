package com.joel.spring.services;

import com.joel.spring.dtos.cart.AddProductToCartDTO;
import com.joel.spring.dtos.cart.ProductInfoDTO;
import com.joel.spring.entities.Cart;
import com.joel.spring.exceptions.NotFoundException;

import java.util.List;

public interface CartService {

    void saveByEntity(Cart cart);

    String addProduct(AddProductToCartDTO body, String id);

    Cart findById(String id) throws NotFoundException;
    Cart findByUserId(String userId) throws NotFoundException;

    List<ProductInfoDTO> getUserCard(String id) throws NotFoundException;
}
