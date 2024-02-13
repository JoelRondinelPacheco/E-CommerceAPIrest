package com.joel.spring.product.application.port.output;

import com.joel.spring.product.domain.Product;
import com.joel.spring.product.dto.UpdateStockDTO;

public interface UpdateStockPort {
    Product update(UpdateStockDTO productStockDTO);
}
