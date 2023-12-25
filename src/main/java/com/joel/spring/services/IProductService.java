package com.joel.spring.services;

import com.joel.spring.dtos.products.ProductEditReqDTO;
import com.joel.spring.dtos.products.ProductInfoDTO;
import com.joel.spring.dtos.products.ProductPostReqDTO;
import com.joel.spring.entities.Product;
import com.joel.spring.exceptions.NotFoundException;

import java.util.List;

public interface IProductService extends ICrudService<Product, ProductPostReqDTO, ProductEditReqDTO, String> {
    public Product save(ProductPostReqDTO dto);
    ProductInfoDTO updateDTO(ProductEditReqDTO dto) throws NotFoundException;
    ProductInfoDTO getDTOById(String id) throws NotFoundException;
    ProductInfoDTO saveAndReturnDTO(ProductPostReqDTO dto);
    int updateQuantity(String id, Double quantity);
    List<ProductInfoDTO> getLackStock(Long quantity);

    List<ProductInfoDTO> getAllDTO();
    List<ProductInfoDTO> getProductnInfoBySaleId(String saleId);
}
