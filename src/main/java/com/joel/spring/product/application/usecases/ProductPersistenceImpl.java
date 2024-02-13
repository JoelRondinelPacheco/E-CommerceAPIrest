package com.joel.spring.product.application.usecases;

import com.joel.spring.product.application.port.input.ProductPersistence;
import com.joel.spring.product.application.port.input.ProductSelector;
import com.joel.spring.product.application.port.output.ProductPersistencePort;
import com.joel.spring.product.domain.Product;
import com.joel.spring.product.dto.ProductEditReqDTO;
import com.joel.spring.product.dto.ProductPostReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ProductPersistenceImpl implements ProductPersistence {

    @Autowired
    private ProductPersistencePort productPersistencePort;

    @Autowired
    @Qualifier("productById")
    private ProductSelector<String> productById;

    @Override
    public Product save(ProductPostReqDTO product) {
        return null;
    }

    @Override
    public Product update(ProductEditReqDTO product) {
        return null;
    }
}
