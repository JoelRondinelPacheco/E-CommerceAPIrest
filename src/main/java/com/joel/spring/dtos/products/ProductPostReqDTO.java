package com.joel.spring.dtos.products;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductPostReqDTO {
    private String name;
    private String brand;
    private Double price;
    private Double quantity_available;
}
