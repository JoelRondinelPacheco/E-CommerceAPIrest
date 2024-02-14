package com.joel.spring.sales.application.port.output;

import com.joel.spring.sales.dto.SaleInfoDTO;

import java.util.List;

public interface SaleSelectorRepositoryPort <T> {
    public List<SaleInfoDTO> get(T t);
}
