package com.joel.spring.product.application.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class ProductEditReqDTO extends ProductPostReqDTO{
    private String productId;

}
