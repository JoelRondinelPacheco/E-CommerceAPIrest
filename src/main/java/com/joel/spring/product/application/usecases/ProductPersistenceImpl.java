package com.joel.spring.product.application.usecases;

import com.joel.spring.category.application.port.input.CategoryService;
import com.joel.spring.category.domain.Category;
import com.joel.spring.product.application.port.input.ProductPersistence;
import com.joel.spring.product.application.port.input.ProductSelector;
import com.joel.spring.product.application.port.output.ProductPersistencePort;
import com.joel.spring.product.domain.Product;
import com.joel.spring.product.application.dto.ProductEditReqDTO;
import com.joel.spring.product.application.dto.ProductInfoDTO;
import com.joel.spring.product.application.dto.ProductPostReqDTO;
import com.joel.spring.product.utils.builder.BuildProductsDTO;
import com.joel.spring.product.utils.builder.ProductBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
    public Product save(ProductPostReqDTO productDTO) {

        List<Category> categories  = this.categoryService.categoriesById(productDTO.getCategoriesId());

        Product product = this.builder.product(productDTO);
        product.setCategories(categories);

        return this.productPersistencePort.save(product);
    }

    @Override
    public ProductInfoDTO update(ProductEditReqDTO product) {
        return null;
    }
}
