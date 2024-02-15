package com.joel.spring.sales.application.port.output;

import com.joel.spring.sales.domain.Sale;
import com.joel.spring.sales.application.dto.SaleInfoDTO;

import java.util.List;

public interface SaleSelectorRepositoryPort {
    public List<SaleInfoDTO> getAll();
    Sale byId(String saleId);

}
