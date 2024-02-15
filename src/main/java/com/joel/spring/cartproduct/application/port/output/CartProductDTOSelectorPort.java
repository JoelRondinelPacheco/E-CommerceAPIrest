package com.joel.spring.cartproduct.application.port.output;

import com.joel.spring.cartproduct.application.dto.ProductCartInfoDTO;

import java.util.List;

public interface CartProductDTOSelectorPort {
    ProductCartInfoDTO byId(String id);
    List<ProductCartInfoDTO> byCartId(String id);
    List<ProductCartInfoDTO> byUserEmail(String userEmail);
    List<ProductCartInfoDTO> byUserId(String userId);

}
