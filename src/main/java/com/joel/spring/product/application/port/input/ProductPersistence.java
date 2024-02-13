package com.joel.spring.product.application.port.input;

import com.joel.spring.product.dto.ProductEditReqDTO;
import com.joel.spring.product.dto.ProductInfoDTO;
import com.joel.spring.product.dto.ProductPostReqDTO;
import com.joel.spring.product.domain.Product;

public interface ProductPersistence {
    ProductInfoDTO save(ProductPostReqDTO product);
    ProductInfoDTO update(ProductEditReqDTO product);
}
