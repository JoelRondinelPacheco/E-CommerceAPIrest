package com.joel.spring.product.adapter.out.persistence;

import com.joel.spring.product.application.port.output.ProductSelectorPort;
import com.joel.spring.product.application.dto.ProductInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class ProductSelectorPersistenceAdapter implements ProductSelectorPort {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<ProductInfoDTO> getByUserId(String userId) {
        return null;
    }

    @Override
    public ProductInfoDTO getById(String id) {
        Optional<ProductInfoDTO> productOptional = this.productRepository.getDTOById(id);
        //TODO CREATE GLOBAL FUNCTION
        if (productOptional.isPresent()) {
            return productOptional.get();
        }
        //TODO CREATE CUSTOM EX
        throw new RuntimeException("TODO CUSTOM EX");
    }

    @Override
    public List<ProductInfoDTO> getAll() {
        return null;
    }
}
