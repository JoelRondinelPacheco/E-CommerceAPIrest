package com.joel.spring.product.utils.builder;

import com.joel.spring.product.domain.Product;
import com.joel.spring.product.dto.ProductPersistenceDTO;
import com.joel.spring.product.dto.ProductPostReqDTO;

import java.util.List;

public interface ProductBuilder {
    Product product(ProductPostReqDTO productDTO);
    ProductPersistenceDTO productPersistence(ProductPostReqDTO productDTO);
}
