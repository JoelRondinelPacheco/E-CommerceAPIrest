package com.joel.spring.sales.application.usecases;

import com.joel.spring.dtos.products.ProductInfoDTO;
import com.joel.spring.dtos.sales.SaleInfoDTO;

import java.util.List;

public interface SaleService {
    List<ProductInfoDTO> products(String saleId);
    List<SaleInfoDTO> maxAmountSale();
}
