package com.joel.spring.product.adapter.out.persistence;

import com.joel.spring.product.application.port.output.ProductSelectorPort;
import com.joel.spring.product.application.dto.ProductInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductSelectorPersistenceAdapter implements ProductSelectorPort {
    @Autowired
    private ProductDTORepository productDTORepository;
    @Override
    public List<ProductInfoDTO> getByUserId(String userId) {
        return null;
    }

    @Override
    public ProductInfoDTO getById(String id) {
        Optional<ProductInfoDTO> productOptional = this.productDTORepository.getDTOById(id);
        //TODO CREATE GLOBAL FUNCTION
        if (productOptional.isPresent()) {
            return productOptional.get();
        }
        //TODO CREATE CUSTOM EX
        throw new RuntimeException("TODO CUSTOM EX");
    }

    @Override
    public List<ProductInfoDTO> getAll() {
        return this.productDTORepository.getAllDTOs();
    }
}
