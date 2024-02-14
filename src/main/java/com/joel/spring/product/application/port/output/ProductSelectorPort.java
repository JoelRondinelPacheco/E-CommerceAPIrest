package com.joel.spring.product.application.port.output;

import com.joel.spring.product.application.dto.ProductInfoDTO;

import java.util.List;

public interface ProductSelectorPort {
    List<ProductInfoDTO> getByUserId(String userId);
    ProductInfoDTO getById(String id);

    List<ProductInfoDTO> getAll();
}
