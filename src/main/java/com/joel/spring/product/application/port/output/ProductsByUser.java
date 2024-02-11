package com.joel.spring.product.application.port.output;

import com.joel.spring.product.domain.Product;

import java.util.List;

public interface ProductsByUser {
    List<Product> get(String userId);
}
