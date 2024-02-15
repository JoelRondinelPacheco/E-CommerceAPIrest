package com.joel.spring.sales.application.dto;

import lombok.Data;

@Data
public class SaleEditReqDTO extends SalePostReqDTO {
    private String saleId;
}
