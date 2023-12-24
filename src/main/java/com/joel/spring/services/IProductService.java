package com.joel.spring.services;

import com.joel.spring.dtos.products.ProductEditReqDTO;
import com.joel.spring.dtos.products.ProductInfoDTO;
import com.joel.spring.dtos.products.ProductPostReqDTO;
import com.joel.spring.entities.Product;

import java.util.List;

public interface IProductService extends ICrudService<Product, ProductPostReqDTO, ProductEditReqDTO, String> {
    public Product save(ProductPostReqDTO dto);
    ProductInfoDTO saveAndReturnDTO(ProductPostReqDTO dto);
    int updateQuantity(String id, Double quantity);
    List<Product> getLackStock(Long quantity);
}
