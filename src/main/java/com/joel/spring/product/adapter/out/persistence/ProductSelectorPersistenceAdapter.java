package com.joel.spring.product.adapter.out.persistence;

import com.joel.spring.product.application.port.output.ProductSelectorPort;
import com.joel.spring.product.application.dto.ProductInfoDTO;

import java.util.List;

public class ProductSelectorPersistenceAdapter implements ProductSelectorPort {
    @Override
    public List<ProductInfoDTO> getByUserId(String userId) {
        return null;
    }

    @Override
    public ProductInfoDTO getById(String id) {
        return null;
    }

    @Override
    public List<ProductInfoDTO> getAll() {
        return null;
    }
}
