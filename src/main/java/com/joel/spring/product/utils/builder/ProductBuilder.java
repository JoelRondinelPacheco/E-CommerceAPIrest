package com.joel.spring.product.utils.builder;

import com.joel.spring.product.domain.Product;
import com.joel.spring.product.application.dto.ProductPersistenceDTO;
import com.joel.spring.product.application.dto.ProductPostReqDTO;

public interface ProductBuilder {
    Product product(ProductPostReqDTO productDTO);
    ProductPersistenceDTO productPersistence(ProductPostReqDTO productDTO);
}
