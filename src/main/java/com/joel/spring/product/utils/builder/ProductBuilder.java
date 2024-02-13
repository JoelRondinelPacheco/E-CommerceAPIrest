package com.joel.spring.product.utils.builder;

import com.joel.spring.product.domain.Product;
import com.joel.spring.product.dto.ProductPostReqDTO;

public interface ProductBuilder {
    Product create(ProductPostReqDTO productDTO);
}
