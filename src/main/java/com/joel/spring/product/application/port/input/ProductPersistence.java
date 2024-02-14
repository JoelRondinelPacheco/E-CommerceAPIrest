package com.joel.spring.product.application.port.input;

import com.joel.spring.product.application.dto.ProductEditReqDTO;
import com.joel.spring.product.application.dto.ProductInfoDTO;
import com.joel.spring.product.application.dto.ProductPostReqDTO;
import com.joel.spring.product.domain.Product;

public interface ProductPersistence {
    Product save(ProductPostReqDTO product);
    ProductInfoDTO update(ProductEditReqDTO product);
}
