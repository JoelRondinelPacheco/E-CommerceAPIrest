package com.joel.spring.services;

import com.joel.spring.dtos.sales.SaleEditReqDTO;
import com.joel.spring.dtos.sales.SaleInfoByDateDTO;
import com.joel.spring.dtos.sales.SaleMaxAmountDTO;
import com.joel.spring.dtos.sales.SalePostReqDTO;
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
}
