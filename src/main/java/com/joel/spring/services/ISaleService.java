package com.joel.spring.services;

import com.joel.spring.dtos.sales.*;
import com.joel.spring.entities.Product;
import com.joel.spring.entities.Sale;
import com.joel.spring.exceptions.NotFoundException;

import java.util.Date;
import java.util.List;

public interface ISaleService extends ICrudService<Sale, SalePostReqDTO, SaleEditReqDTO, String> {
    public Sale save(SalePostReqDTO body) throws NotFoundException;
    List<Product> getProducts(String id);
    SaleInfoByDateDTO getSaleInfoByDate(Date date);
    List<SaleMaxAmountDTO> getMaxAmountSale();

    SaleInfoDTO saveDTO(SalePostReqDTO body) throws NotFoundException;
}
