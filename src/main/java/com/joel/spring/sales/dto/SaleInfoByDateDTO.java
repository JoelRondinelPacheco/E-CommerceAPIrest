package com.joel.spring.sales.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SaleInfoByDateDTO {
    private Double totalAmount;
    private int totalSales;
}
