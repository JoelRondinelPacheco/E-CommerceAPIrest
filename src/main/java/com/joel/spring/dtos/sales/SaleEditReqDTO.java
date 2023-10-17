package com.joel.spring.dtos.sales;

import lombok.Data;

@Data
public class SaleEditReqDTO extends SalePostReqDTO {
    private Long sale_id;
}
