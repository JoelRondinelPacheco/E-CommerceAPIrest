package com.joel.spring.services;

import com.joel.spring.dtos.sales.SaleEditReqDTO;
import com.joel.spring.dtos.sales.SaleInfoByDateDTO;
import com.joel.spring.dtos.sales.SaleMaxAmountDTO;
import com.joel.spring.dtos.sales.SalePostReqDTO;
import com.joel.spring.entities.Product;
import com.joel.spring.entities.Sale;

import java.util.Date;
import java.util.List;

public interface ISaleService extends ICrudService<Sale, SalePostReqDTO, SaleEditReqDTO, Long> {
    List<Product> getProducts(Long id);
    SaleInfoByDateDTO getSaleInfoByDate(Date date);
    List<SaleMaxAmountDTO> getMaxAmountSale();
}
