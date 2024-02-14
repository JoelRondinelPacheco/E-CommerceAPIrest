package com.joel.spring.product.application.dto;

import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductPostReqDTO {
    private String name;
    private String brand;
    private Double price;
    private Long stock;
    private List<String> categoriesId;
}
