package com.joel.spring.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UpdateStockDTO {
    private String productId;
    private Long newStock;
}
