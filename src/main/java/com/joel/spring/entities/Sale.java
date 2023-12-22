package com.joel.spring.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "sales")
@Getter
@Setter
public class Sale {
    @Id
    @UuidGenerator
    private String id;
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private LocalDate saleDate;
    private Double totalPrice;
    @ManyToMany
    @JoinTable(name = "rel_sales_products", joinColumns = @JoinColumn(name = "sales_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;
    @ManyToOne
    @JoinColumn(name="client_id")
    private UserEntity client;

    public Sale() {
    }

    public Sale(UserEntity client, List<Product> products, Double totalPrice) {
        this.client = client;
        this.products = products;
        this.totalPrice = totalPrice;
    }
}
