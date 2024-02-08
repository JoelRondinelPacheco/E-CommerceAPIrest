package com.joel.spring.sales.adapter.output.persistence;

import com.joel.spring.user.infrastructure.output.persistence.UserEntity;
import com.joel.spring.entities.Product;
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
public class SaleEntity {
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

    public SaleEntity() {
    }

    public SaleEntity(UserEntity client, List<Product> products, Double totalPrice) {
        this.client = client;
        this.products = products;
        this.totalPrice = totalPrice;
    }
}
