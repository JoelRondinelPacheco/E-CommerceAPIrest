package com.joel.spring.sales.adapter.output.persistence;

import com.joel.spring.product.application.dto.ProductInfoDTO;
import com.joel.spring.sales.application.port.output.SaleServiceRepositoryPort;
import com.joel.spring.sales.application.dto.SaleMaxAmountDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SaleServicePersistenceAdapter implements SaleServiceRepositoryPort {
    @Override
    public List<ProductInfoDTO> getProductsSale(String saleId) {
        return null;
    }

    @Override
    public List<SaleMaxAmountDTO> maxAmountSale() {
        return null;
    }
}
