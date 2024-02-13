package com.joel.spring.product.application.port.output;

import com.joel.spring.product.domain.Product;

public interface ProductPersistencePort {
    Product save(Product product);
    Product update(Product product);
}
