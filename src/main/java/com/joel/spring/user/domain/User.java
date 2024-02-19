package com.joel.spring.user.domain;

import com.joel.spring.accounttoken.domain.AccountToken;
import com.joel.spring.cart.domain.Cart;
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
    private boolean verified;

    private AccountToken accountToken;

    public AccountToken getAccountToken() {
        return accountToken;
    }

    public void setAccountToken(AccountToken accountToken) {
        this.accountToken = accountToken;
    }

    private List<Sale> sale;
    private Cart cart;
//TODO default verified??
    public User() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }


    public List<Sale> getSale() {
        return sale;
    }

    public void setSale(List<Sale> sale) {
        this.sale = sale;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
