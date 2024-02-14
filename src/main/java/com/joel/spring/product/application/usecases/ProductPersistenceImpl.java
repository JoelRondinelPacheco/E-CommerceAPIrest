package com.joel.spring.product.application.usecases;

import com.joel.spring.category.application.port.input.CategoryService;
import com.joel.spring.category.domain.Category;
import com.joel.spring.product.application.port.input.ProductPersistence;
import com.joel.spring.product.application.port.input.ProductSelector;
import com.joel.spring.product.application.port.output.ProductPersistencePort;
import com.joel.spring.product.domain.Product;
import com.joel.spring.product.dto.ProductEditReqDTO;
import com.joel.spring.product.dto.ProductInfoDTO;
import com.joel.spring.product.dto.ProductPersistenceDTO;
import com.joel.spring.product.dto.ProductPostReqDTO;
import com.joel.spring.product.utils.builder.BuildProductsDTO;
import com.joel.spring.product.utils.builder.ProductBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;

public class ProductPersistenceImpl implements ProductPersistence {


    @Autowired
    private ProductBuilder builder;
    @Autowired
    private BuildProductsDTO dtoBuilder;
    @Autowired
    private ProductPersistencePort productPersistencePort;

    @Autowired
    private CategoryService categoryService;
    @Autowired
    @Qualifier("productById")
    private ProductSelector<ProductInfoDTO, String> productById;

    @Override
    public ProductInfoDTO save(ProductPostReqDTO productDTO) {
        //TODO get all entities
        List<Category> categories  = this.categoryService.categoriesById(productDTO.getCategoriesId());

        Product product = this.builder.product(productDTO);
        product.setCategories(categories);

        Product productSaved = this.productPersistencePort.save(product);

        return this.dtoBuilder.productInfoDTO(productSaved);
    }

    @Override
    public ProductInfoDTO update(ProductEditReqDTO product) {
        return null;
    }
}
