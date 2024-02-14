package com.joel.spring.product.application.port.output;

import com.joel.spring.product.application.dto.ProductInfoDTO;
import com.joel.spring.product.domain.Product;

import java.util.List;

public interface ProductDomainSelectorPort {
    List<Product> getByUserId(String userId);
    Product getById(String id);

    List<Product> getAll();
}
