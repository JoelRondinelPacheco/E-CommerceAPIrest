package com.joel.spring.product.application.port.output;

import com.joel.spring.product.domain.Product;
import com.joel.spring.product.dto.ProductInfoDTO;
import com.joel.spring.product.dto.UpdateStockDTO;

import java.util.List;

public interface UpdateStockPort {
    Product update(UpdateStockDTO productStockDTO);
    List<ProductInfoDTO> lowStockProducts(Long stock);
}
