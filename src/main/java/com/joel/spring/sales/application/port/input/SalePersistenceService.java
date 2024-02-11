package com.joel.spring.sales.application.port.input;

import com.joel.spring.dtos.sales.SalePostReqDTO;
import com.joel.spring.sales.domain.Sale;

public interface SalePersistenceService {

    Sale save(SalePostReqDTO sale);

    Sale update(Sale sale);


}
