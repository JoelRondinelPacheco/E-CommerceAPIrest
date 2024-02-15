package com.joel.spring.cartproduct.adapter.output.persistence;

import com.joel.spring.cartproduct.application.dto.ProductCartInfoDTO;
import com.joel.spring.cartproduct.application.port.output.CartProductDTOSelectorPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartProductDTOSelectorPersistenceAdapter implements CartProductDTOSelectorPort {

    @Autowired
    private CartProductDTOMySQLRepository cartRepository;

    @Override
    public ProductCartInfoDTO byId(String id) {
        return null;
    }

    @Override
    public List<ProductCartInfoDTO> byCartId(String id) {
        return null;
    }

    @Override
    public List<ProductCartInfoDTO> byUserEmail(String userEmail) {
        return null;
    }

    @Override
    public List<ProductCartInfoDTO> byUserId(String userId) {
        return this.cartRepository.findByCart_User_Id(userId);
    }
}
