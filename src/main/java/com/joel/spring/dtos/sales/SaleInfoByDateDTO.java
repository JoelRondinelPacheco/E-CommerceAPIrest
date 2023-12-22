package com.joel.spring.dtos.sales;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SaleInfoByDateDTO {
    private Double totalAmount;
    private int totalSales;
}
