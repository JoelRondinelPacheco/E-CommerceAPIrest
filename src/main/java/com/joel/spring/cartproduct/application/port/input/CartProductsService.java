package com.joel.spring.cartproduct.application.port.input;

import com.joel.spring.cartproduct.application.dto.AddProductToCartDTO;
import com.joel.spring.cart.application.dto.UpdateQuantityDTO;

public interface CartProductsService {
    String add(AddProductToCartDTO info);
    String delete(String cartProductId);
    String editQuantity(UpdateQuantityDTO info);
    String plusQuantity(UpdateQuantityDTO info);
    String minusQuantity(UpdateQuantityDTO info);
}
