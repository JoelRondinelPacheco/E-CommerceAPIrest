package com.joel.spring.cart.adapter.input;

import com.joel.spring.cart.domain.Cart;
import com.joel.spring.product.dto.ProductInfoDTO;

import java.util.List;

public interface CartProductService {
    ProductInfoDTO add(List<String> productsId);
    Long deleteAll(String cartId);
    //TODO CREATE DTO
    Cart editQuantity(Long quantity);
}
