package com.joel.spring.sales.application.usecases;

import com.joel.spring.sales.domain.Sale;

public interface SalePersistence {
    Sale save(Sale sale);
    Sale update(Sale sale);
}
