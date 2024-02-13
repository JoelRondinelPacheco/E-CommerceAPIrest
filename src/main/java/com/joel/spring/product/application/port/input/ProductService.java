package com.joel.spring.product.application.port.input;

import com.joel.spring.product.domain.Product;
import com.joel.spring.product.dto.ProductInfoDTO;
import com.joel.spring.product.dto.UpdateStockDTO;

import java.util.List;

public interface ProductService {
    Product updateStock(UpdateStockDTO newStock);
    List<ProductInfoDTO> lowStockProducts(Long stock);
}
