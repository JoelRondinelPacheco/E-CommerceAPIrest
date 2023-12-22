package com.joel.spring.dtos.sales;

import lombok.Data;

@Data
public class SaleEditReqDTO extends SalePostReqDTO {
    private String saleId;
}
