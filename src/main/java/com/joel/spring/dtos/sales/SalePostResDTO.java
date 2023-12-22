package com.joel.spring.dtos.sales;

import com.joel.spring.entities.UserEntity;
import com.joel.spring.entities.Product;
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
    private List<Product> products;
    private UserEntity userEntity;
}
