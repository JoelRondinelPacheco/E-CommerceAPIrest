package com.joel.spring.cartproduct.application.usecases;

import com.joel.spring.cartproduct.application.dto.ProductCartInfoDTO;
import com.joel.spring.cartproduct.application.port.input.CartProductSelector;
import com.joel.spring.cartproduct.application.port.output.CartProductDTOSelectorPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartProductSelectorImpl implements CartProductSelector {

    @Autowired
    private CartProductDTOSelectorPort cartRepository;

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
        return this.cartRepository.byUserId(userId);
    }
}
