package com.joel.spring.services;

import com.joel.spring.product.dto.ProductEditReqDTO;
import com.joel.spring.product.dto.ProductInfoDTO;
import com.joel.spring.product.dto.ProductPostReqDTO;
import com.joel.spring.product.adapter.out.persistence.ProductEntity;
import com.joel.spring.exceptions.NotFoundException;

import java.util.List;

public interface ProductService extends CrudService<ProductEntity, ProductPostReqDTO, ProductEditReqDTO, String> {
    public ProductEntity save(ProductPostReqDTO dto);
    ProductInfoDTO updateDTO(ProductEditReqDTO dto) throws NotFoundException;
    ProductInfoDTO getDTOById(String id) throws NotFoundException;
    ProductInfoDTO saveAndReturnDTO(ProductPostReqDTO dto);
    int updateQuantity(String id, Double quantity);
    List<ProductInfoDTO> getLowStock(Long quantity);

    List<ProductInfoDTO> getAllDTO();
    List<ProductInfoDTO> getProductInfoBySaleId(String saleId);
}
