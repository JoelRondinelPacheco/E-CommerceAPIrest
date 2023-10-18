package com.joel.spring.services;

import com.joel.spring.dtos.products.ProductEditReqDTO;
import com.joel.spring.dtos.products.ProductPostReqDTO;
import com.joel.spring.entities.Product;

public interface IProductService extends ICrudService<Product, ProductPostReqDTO, ProductEditReqDTO, Long>{
}
