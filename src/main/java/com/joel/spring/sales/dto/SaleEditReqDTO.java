package com.joel.spring.sales.dto;

import lombok.Data;

@Data
public class SaleEditReqDTO extends SalePostReqDTO {
    private String saleId;
}
