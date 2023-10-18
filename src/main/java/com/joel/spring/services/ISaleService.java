package com.joel.spring.services;

import com.joel.spring.dtos.sales.SaleEditReqDTO;
import com.joel.spring.dtos.sales.SalePostReqDTO;
import com.joel.spring.entities.Sale;

public interface ISaleService extends ICrudService<Sale, SalePostReqDTO, SaleEditReqDTO, Long> {
}
