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
    private Long quantity_available;
}
