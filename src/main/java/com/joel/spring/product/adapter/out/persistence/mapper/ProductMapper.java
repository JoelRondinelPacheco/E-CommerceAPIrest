package com.joel.spring.product.adapter.out.persistence.mapper;

import com.joel.spring.product.adapter.out.persistence.ProductEntity;
import com.joel.spring.product.domain.Product;
import com.joel.spring.utils.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("productMapper")
public class ProductMapper implements Mapper<ProductEntity, Product> {
    @Override
    public Product entityToDomain(ProductEntity productEntity) {
        return null;
    }

    @Override
    public ProductEntity domainToEntity(Product product) {
        return null;
    }
}
