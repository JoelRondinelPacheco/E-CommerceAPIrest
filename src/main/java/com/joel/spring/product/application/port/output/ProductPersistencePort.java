package com.joel.spring.product.application.port.output;

import com.joel.spring.product.domain.Product;
import com.joel.spring.product.dto.ProductPersistenceDTO;

public interface ProductPersistencePort {
    Product save(Product product);
    Product update(Product product);
}
