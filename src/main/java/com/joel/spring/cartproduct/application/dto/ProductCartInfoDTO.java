package com.joel.spring.cartproduct.application.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductCartInfoDTO {
    private String cartProductId;
    private String productId;
    private String name;
    private String brand;
    private Double price;
    private Integer quantity;
}
