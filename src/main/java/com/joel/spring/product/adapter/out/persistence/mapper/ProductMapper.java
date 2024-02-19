package com.joel.spring.product.adapter.out.persistence.mapper;

import com.joel.spring.category.adapter.output.persistence.CategoryEntity;
import com.joel.spring.category.domain.Category;
import com.joel.spring.product.adapter.out.persistence.ProductEntity;
import com.joel.spring.product.domain.Product;
import com.joel.spring.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("productMapper")
public class ProductMapper implements Mapper<ProductEntity, Product> {

    @Autowired
    private Mapper<CategoryEntity, Category> categoryMapper;

    @Override
    public Product entityToDomain(ProductEntity productEntity) {
        return null;
    }

    @Override
    public ProductEntity domainToEntity(Product product) {
        ProductEntity productEntity = ProductEntity.builder()
                .name(product.getName())
                .brand(product.getBrand())
                .price(product.getPrice())
                .stock(product.getStock())
                .build();

        return productEntity;

    }
}
