package com.joel.spring.dtos.sales;

import lombok.Data;

import java.util.List;

@Data
public class SalePostReqDTO {
    //private Double total_price;
    private String clientId;
    private List<String> products;
}
