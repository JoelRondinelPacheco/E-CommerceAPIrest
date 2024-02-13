package com.joel.spring.product.application.usecases;

import com.joel.spring.category.application.port.input.CategoryService;
import com.joel.spring.category.domain.Category;
import com.joel.spring.product.application.port.input.ProductPersistence;
import com.joel.spring.product.application.port.input.ProductSelector;
import com.joel.spring.product.application.port.output.ProductPersistencePort;
import com.joel.spring.product.domain.Product;
import com.joel.spring.product.dto.ProductEditReqDTO;
import com.joel.spring.product.dto.ProductPostReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;

public class ProductPersistenceImpl implements ProductPersistence {

    @Autowired
    private ProductPersistencePort productPersistencePort;

    @Autowired
    private CategoryService categoryService;
    @Autowired
    @Qualifier("productById")
    private ProductSelector<String> productById;

    @Override
    public Product save(ProductPostReqDTO product) {

        List<Category> c = this.categoryService.categoriesById(product.getCategoriesId());


        return null;
    }

    @Override
    public Product update(ProductEditReqDTO product) {
        return null;
    }
}
