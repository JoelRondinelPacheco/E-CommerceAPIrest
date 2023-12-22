package com.joel.spring.services;

import com.joel.spring.dtos.cart.AddProductToCartDTO;
import com.joel.spring.dtos.cartproduct.UpdateQuantityDTO;
import com.joel.spring.entities.CartProduct;
import com.joel.spring.exceptions.NotFoundException;

public interface ICartProductService {
    CartProduct saveProduct(AddProductToCartDTO dto, String userId) throws NotFoundException;
    void deleteProduct(String productId) throws NotFoundException;
    CartProduct changeQuantity(UpdateQuantityDTO dto) throws NotFoundException;

    CartProduct getById(String id) throws NotFoundException;
}
