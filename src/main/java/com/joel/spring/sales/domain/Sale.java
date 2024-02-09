package com.joel.spring.sales.domain;

import com.joel.spring.user.domain.User;
import com.joel.spring.entities.ProductEntity;

import java.time.LocalDate;
import java.util.List;

public class Sale {
    private String id;
    private LocalDate createdAt;
    private Double totalPrice;
    private List<ProductEntity> productEntities;
    private User client;

    public Sale() {
    }
}
