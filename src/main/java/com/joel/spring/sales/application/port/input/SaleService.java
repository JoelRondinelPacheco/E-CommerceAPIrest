package com.joel.spring.sales.application.port.input;

import com.joel.spring.dtos.products.ProductInfoDTO;
import com.joel.spring.dtos.sales.*;

import java.util.List;

public interface SaleService {
    List<ProductInfoDTO> getProducts(String id);
    List<SaleMaxAmountDTO> getMaxAmountSale();

}
