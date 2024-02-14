package com.joel.spring.cart.application.port.input;

import com.joel.spring.cart.domain.Cart;
import com.joel.spring.cartproduct.application.dto.ProductCartInfoDTO;
import com.joel.spring.exceptions.NotFoundException;

import java.util.List;

public interface CartService {
    Cart create();

    List<ProductCartInfoDTO> getUserCard(String id) throws NotFoundException;
}
