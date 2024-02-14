package com.joel.spring.sales.application.usecases.saleselector;

import com.joel.spring.sales.dto.SaleInfoDTO;
import com.joel.spring.sales.application.port.input.SaleSelector;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Qualifier("allSales")
public class AllSales implements SaleSelector<String> {
    @Override
    public List<SaleInfoDTO> get(String s) {
        return null;
    }
}
