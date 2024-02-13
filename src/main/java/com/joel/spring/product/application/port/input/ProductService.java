package com.joel.spring.product.application.port.input;

import com.joel.spring.product.domain.Product;

public interface ProductService {
    Product updateStock(Long newStock);
}
