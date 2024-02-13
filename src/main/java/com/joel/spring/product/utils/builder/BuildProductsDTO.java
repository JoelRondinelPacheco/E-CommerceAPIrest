package com.joel.spring.product.utils.builder;

import com.joel.spring.product.domain.Product;
import com.joel.spring.product.dto.ProductInfoDTO;

import java.util.List;

public interface BuildProductsDTO {

    ProductInfoDTO productInfoDTO(Product product);

    List<ProductInfoDTO> productInfoDTOList(List<Product> products);
    }
