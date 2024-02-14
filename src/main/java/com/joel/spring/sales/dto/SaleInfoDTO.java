package com.joel.spring.sales.dto;

import com.joel.spring.product.application.dto.ProductInfoDTO;
import com.joel.spring.user.application.dto.UserPersonalInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SaleInfoDTO {
    private String saleId;
    private Double totalPrice;
    private UserPersonalInfoDTO client;
    private List<ProductInfoDTO> products;

    public SaleInfoDTO(String saleId, Double totalPrice, UserPersonalInfoDTO client) {
        this.saleId = saleId;
        this.totalPrice = totalPrice;
        this.client = client;
    }
}
