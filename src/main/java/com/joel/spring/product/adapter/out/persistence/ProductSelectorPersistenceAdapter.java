package com.joel.spring.product.adapter.out.persistence;

import com.joel.spring.product.application.port.output.ProductsByUser;
import com.joel.spring.product.domain.Product;

import java.util.List;

public class ProductSelectorPersistenceAdapter implements ProductsByUser {
    @Override
    public List<Product> get(String userId) {
        return null;
    }
}
