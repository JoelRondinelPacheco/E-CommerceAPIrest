package com.joel.spring.sales.application.port.input;

import com.joel.spring.product.application.dto.ProductInfoDTO;
import com.joel.spring.sales.application.dto.SaleMaxAmountDTO;

import java.util.List;

public interface SaleService {
    List<ProductInfoDTO> getProducts(String id);
    List<SaleMaxAmountDTO> getMaxAmountSale();

}
