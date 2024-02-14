package com.joel.spring.services;

import com.joel.spring.cartproduct.application.dto.AddProductToCartDTO;
import com.joel.spring.cart.application.dto.UpdateQuantityDTO;
import com.joel.spring.cartproduct.adapter.output.persistence.CartProductEntity;
import com.joel.spring.exceptions.NotFoundException;

public interface CartProductService {
    CartProductEntity saveProduct(AddProductToCartDTO dto, String userId) throws NotFoundException;
    void deleteProduct(String productId) throws NotFoundException;
    CartProductEntity changeQuantity(UpdateQuantityDTO dto) throws NotFoundException;

    CartProductEntity getById(String id) throws NotFoundException;
}
