package com.joel.spring.sales.application.port.input;

import com.joel.spring.sales.dto.SaleInfoDTO;

import java.util.List;

public interface SaleSelector <T>{
    public List<SaleInfoDTO> get(T t);
}
