package com.joel.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "products")
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@ToString
@JsonIgnoreProperties("sales")
public class Product   {
    @Id
    @UuidGenerator
    private String id;
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private LocalDate created;
    @NonNull
    private String name;
    @NonNull
    private String brand;
    @NonNull
    private Double price;
    @NonNull
    private Long quantityAvailable;
    @ManyToMany(mappedBy = "products")
    private List<Sale> sales;
    @ManyToMany(mappedBy = "products")
    private List<Category> categories;
}
