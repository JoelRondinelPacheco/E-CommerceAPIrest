package com.joel.spring.sales.application.port.output;

import com.joel.spring.product.application.dto.ProductInfoDTO;
import com.joel.spring.sales.application.dto.SaleMaxAmountDTO;

import java.util.List;

public interface SaleServiceRepositoryPort {

    List<ProductInfoDTO> getProductsSale(String saleId);
    List<SaleMaxAmountDTO> maxAmountSale();
}
