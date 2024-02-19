package com.joel.spring.cart.adapter.out.persistence;

import com.joel.spring.cart.application.port.output.CartServicePort;
import com.joel.spring.cart.domain.Cart;
import com.joel.spring.cartproduct.application.dto.AddProductToCartDTO;
import com.joel.spring.cartproduct.application.dto.ProductCartInfoDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartServicePersistenceAdapter implements CartServicePort {
    @Override
    public Cart create() {
        return null;
    }

    @Override
    public Long cartProductsQuantity(String cartId) {
        return null;
    }

    @Override
    public List<ProductCartInfoDTO> getUserCard(String id) {
        return null;
    }

    @Override
    public void addProduct(AddProductToCartDTO info) {

    }
}
