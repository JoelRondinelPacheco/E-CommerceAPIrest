package com.joel.spring.sales.application.dto;

import com.joel.spring.product.adapter.out.persistence.ProductEntity;
import com.joel.spring.user.infrastructure.output.persistence.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SalePostResDTO {
    private String saleId;
    private LocalDate saleDate;
    private Double totalPrice;
    private List<ProductEntity> productEntities;
    private UserEntity userEntity;
}
