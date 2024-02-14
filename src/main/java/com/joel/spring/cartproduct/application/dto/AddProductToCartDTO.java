package com.joel.spring.cartproduct.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddProductToCartDTO {
    private String cartId;
    private String productId;
    private Integer quantity;
}
