package com.joel.spring.sales.adapter.output.persistence.selector;

import com.joel.spring.sales.dto.SaleInfoDTO;
import com.joel.spring.sales.application.port.output.SaleSelectorRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SaleByIdPersistenceAdapter implements SaleSelectorRepositoryPort<String> {

    @Autowired
    private SaleSelectorRepository saleRepository;

    @Override
    public List<SaleInfoDTO> get(String s) {

        return null;
    }
}
