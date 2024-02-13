package com.joel.spring.product.utils.builder;

import com.joel.spring.dtos.cart.ProductInfoDTO;
import com.joel.spring.product.domain.Product;
import com.joel.spring.product.dto.ProductPostReqDTO;

public class ProductBuilderImpl implements ProductBuilder{
    @Override
    public Product create(ProductPostReqDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setBrand(productDTO.getBrand());
        product.setStock(productDTO.getStock());
        return null;
    }
}
