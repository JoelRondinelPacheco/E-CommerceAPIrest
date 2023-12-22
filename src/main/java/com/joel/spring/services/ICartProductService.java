package com.joel.spring.services;

import com.joel.spring.dtos.cart.AddProductToCartDTO;
import com.joel.spring.entities.CartProduct;
import com.joel.spring.exceptions.NotFoundException;

public interface ICartProductService {
    public CartProduct save(AddProductToCartDTO dto, String userId) throws NotFoundException;

    public CartProduct getById(String id) throws NotFoundException;
}
