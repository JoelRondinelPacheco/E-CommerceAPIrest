package com.joel.spring.sales.dto;

import lombok.Data;

import java.util.List;

@Data
public class SalePostReqDTO {
    //private Double total_price;
    private String clientId;
    private List<String> products;
}
