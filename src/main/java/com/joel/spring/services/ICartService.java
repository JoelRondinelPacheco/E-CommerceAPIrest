package com.joel.spring.services;

import com.joel.spring.dtos.cart.AddProductToCartDTO;
import com.joel.spring.entities.Cart;
import com.joel.spring.exceptions.NotFoundException;

public interface ICartService {

    void saveByEntity(Cart cart);

    String addProduct(AddProductToCartDTO body, String id);

    Cart findById(String id) throws NotFoundException;
    Cart findByUserId(String userId) throws NotFoundException;
}
