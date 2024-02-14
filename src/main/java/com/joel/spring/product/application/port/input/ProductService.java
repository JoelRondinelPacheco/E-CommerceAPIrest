package com.joel.spring.product.application.port.input;

import com.joel.spring.product.domain.Product;
import com.joel.spring.product.application.dto.ProductInfoDTO;
import com.joel.spring.product.application.dto.UpdateStockDTO;

import java.util.List;

public interface ProductService {
    ProductInfoDTO updateStock(UpdateStockDTO newStock);
    List<ProductInfoDTO> lowStockProducts(Long stock);
}
