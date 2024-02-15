package com.joel.spring.sales.adapter.output.persistence.selector;

import com.joel.spring.sales.domain.Sale;
import com.joel.spring.sales.application.dto.SaleInfoDTO;
import com.joel.spring.sales.application.port.output.SaleSelectorRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SaleSelectorPersistenceAdapter implements SaleSelectorRepositoryPort {

    @Autowired
    private SaleSelectorRepository saleRepository;


    @Override
    public List<SaleInfoDTO> getAll() {
        return null;
    }

    @Override
    public Sale byId(String saleId) {
        return null;
    }
}
