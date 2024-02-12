package com.joel.spring.sales.application.usecases;

import com.joel.spring.dtos.sales.SaleInfoDTO;

import java.util.List;

public interface SaleSelector <T> {
    List<SaleInfoDTO> get(T t);
}
