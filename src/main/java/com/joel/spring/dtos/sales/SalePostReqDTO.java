package com.joel.spring.dtos.sales;

import lombok.Data;

import java.util.List;

@Data
public class SalePostReqDTO {
    //private Double total_price;
    private Long client_id;
    private List<Long> products;
}
