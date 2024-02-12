package com.joel.spring.sales.application.usecases.saleselector;

import com.joel.spring.dtos.sales.SaleInfoDTO;
import com.joel.spring.sales.application.port.input.SaleSelector;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Qualifier("saleByDate")
public class SalesByDate implements SaleSelector<Date> {
    @Override
    public List<SaleInfoDTO> get(Date date) {
        return null;
    }
}
