package com.joel.spring.sales.application.port.input;

import com.joel.spring.dtos.sales.*;
import com.joel.spring.entities.Product;
import com.joel.spring.sales.adapter.output.persistence.SaleEntity;
import com.joel.spring.exceptions.NotFoundException;
import com.joel.spring.services.CrudService;

import java.util.Date;
import java.util.List;

public interface SaleService extends CrudService<SaleEntity, SalePostReqDTO, SaleEditReqDTO, String> {
    public SaleEntity save(SalePostReqDTO body) throws NotFoundException;
    List<Product> getProducts(String id);
    SaleInfoByDateDTO getSaleInfoByDate(Date date);
    List<SaleMaxAmountDTO> getMaxAmountSale();

    SaleInfoDTO saveDTO(SalePostReqDTO body) throws NotFoundException;

    List<SaleInfoDTO> getAllDTO();

    SaleInfoDTO getByIdDTO(String saleId) throws NotFoundException;

}
