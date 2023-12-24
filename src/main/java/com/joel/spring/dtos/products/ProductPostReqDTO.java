package com.joel.spring.dtos.products;

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
