package com.joel.spring.sales.domain;

import com.joel.spring.client.domain.User;
import com.joel.spring.entities.Product;

import java.time.LocalDate;
import java.util.List;

public class Sale {
    private String id;
    private LocalDate saleDate;
    private Double totalPrice;
    private List<Product> products;
    private User client;

    public Sale() {
    }
}
