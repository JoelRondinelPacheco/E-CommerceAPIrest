package com.joel.spring.services;

import com.joel.spring.dtos.products.ProductEditReqDTO;
import com.joel.spring.dtos.products.ProductPostReqDTO;
import com.joel.spring.entities.Product;

import java.util.List;

public interface IProductService extends ICrudService<Product, ProductPostReqDTO, ProductEditReqDTO, Long> {
    public Product save(ProductPostReqDTO dto);
    int updateQuantity(Long id, Double quantity);
    List<Product> getLackStock(Long quantity);
}
