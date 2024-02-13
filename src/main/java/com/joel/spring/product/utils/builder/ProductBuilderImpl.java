package com.joel.spring.product.utils.builder;

import com.joel.spring.product.domain.Product;
import com.joel.spring.product.dto.ProductPersistenceDTO;
import com.joel.spring.product.dto.ProductPostReqDTO;

public class ProductBuilderImpl implements ProductBuilder{
    @Override
    public Product product(ProductPostReqDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setBrand(productDTO.getBrand());
        product.setStock(productDTO.getStock());
        return product;
    }

    @Override
    public ProductPersistenceDTO productPersistence(ProductPostReqDTO productDTO) {
        return new ProductPersistenceDTO(this.product(productDTO), productDTO.getCategoriesId());
    }
}
