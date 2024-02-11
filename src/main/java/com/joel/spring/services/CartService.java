package com.joel.spring.services;

import com.joel.spring.dtos.cart.AddProductToCartDTO;
import com.joel.spring.dtos.cart.ProductInfoDTO;
import com.joel.spring.cart.adapter.out.persistence.entity.CartEntity;
import com.joel.spring.exceptions.NotFoundException;

import java.util.List;

public interface CartService {

    void saveByEntity(CartEntity cartEntity);

    String addProduct(AddProductToCartDTO body, String id);

    CartEntity findById(String id) throws NotFoundException;
    CartEntity findByUserId(String userId) throws NotFoundException;

    List<ProductInfoDTO> getUserCard(String id) throws NotFoundException;
}
