package com.joel.spring.product.adapter.out.persistence;

import com.joel.spring.category.adapter.output.persistence.entity.CategoryEntity;
import com.joel.spring.category.adapter.output.persistence.CategoryRepository;
import com.joel.spring.product.application.port.output.ProductPersistencePort;
import com.joel.spring.product.domain.Product;
import com.joel.spring.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductPersistenceAdapter implements ProductPersistencePort {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    @Qualifier("productMapper")
    private Mapper<ProductEntity, Product> mapper;
    //TODO REFACTOR
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Product save(Product product) {
        ProductEntity productEntity = this.mapper.domainToEntity(product);

        List<CategoryEntity> categories = this.categoryRepository.findAllById(product.getCategoriesId());
        productEntity.setCategories(categories);

        return this.mapper.entityToDomain(this.productRepository.save(productEntity));
    }

    @Override
    public Product update(Product product) {
        return null;
    }
}
