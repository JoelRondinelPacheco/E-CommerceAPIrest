package com.joel.spring.sales.application.port.output;

import com.joel.spring.dtos.products.ProductInfoDTO;
import com.joel.spring.dtos.sales.SaleMaxAmountDTO;

import java.util.List;

public interface SaleServiceRepositoryPort {

    List<ProductInfoDTO> getProductsSale(String saleId);
    List<SaleMaxAmountDTO> maxAmountSale();
}
