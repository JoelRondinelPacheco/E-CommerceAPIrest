package com.joel.spring.cart.application.port.output;

import com.joel.spring.cart.domain.Cart;
import com.joel.spring.cartproduct.application.dto.AddProductToCartDTO;
import com.joel.spring.cartproduct.application.dto.ProductCartInfoDTO;

import java.util.List;

public interface CartServicePort {
    Cart create();
    Long cartProductsQuantity(String cartId);
    List<ProductCartInfoDTO> getUserCard(String id);
    void addProduct(AddProductToCartDTO info);
}
