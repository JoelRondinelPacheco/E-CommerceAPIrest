package com.joel.spring.sales.application.port.input;

import com.joel.spring.dtos.sales.SaleInfoDTO;

import java.util.List;

public interface SaleSelector <T>{
    public List<SaleInfoDTO> get(T t);
}
