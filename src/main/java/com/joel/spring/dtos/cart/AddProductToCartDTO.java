package com.joel.spring.dtos.cart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddProductToCartDTO {
    private String productId;
    private Integer quantity;
}
