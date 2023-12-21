package com.joel.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "sales")
@Getter
@Setter
public class Sale {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long sale_id;
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private LocalDate sale_date;
    private Double total_price;
    //TODO complete oneToMany
    @ManyToMany
    @JoinTable(name = "rel_sales_products", joinColumns = @JoinColumn(name = "sales_id"), inverseJoinColumns = @JoinColumn(name = "products_id"))
    private List<Product> products;
    @ManyToOne
    @JoinColumn(name="client_id")
    private Client client;

    public Sale() {
    }

    public Sale(Client client, List<Product> products, Double total_price) {
        this.client = client;
        this.products = products;
        this.total_price = total_price;
    }
}
