package com.joel.spring.dtos.products;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class ProductEditReqDTO extends ProductPostReqDTO{
    private String productId;

}
