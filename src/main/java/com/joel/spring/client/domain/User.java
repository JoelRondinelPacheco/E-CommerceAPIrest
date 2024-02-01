package com.joel.spring.client.domain;

import com.joel.spring.entities.Cart;
import com.joel.spring.sales.domain.Sale;

import java.time.LocalDate;
import java.util.List;

public class User {
    private String id;
    private LocalDate created;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<Sale> sale;
    private Cart cart;

    public User() {
    }
}
