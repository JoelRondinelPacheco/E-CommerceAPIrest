package com.joel.spring.cartproduct.application.port.input;

import com.joel.spring.cartproduct.application.dto.ProductCartInfoDTO;

import java.util.List;

public interface CartProductSelector {
    ProductCartInfoDTO byId(String id);
    List<ProductCartInfoDTO> byCartId(String id);
    List<ProductCartInfoDTO> byUserEmail(String userEmail);
    List<ProductCartInfoDTO> byUserId(String userId);
}
