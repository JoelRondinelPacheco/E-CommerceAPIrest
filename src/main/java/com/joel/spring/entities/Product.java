package com.joel.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.List;

@Entity(name = "products")
@NoArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
@ToString
@JsonIgnoreProperties("sales")
public class Product   {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long product_id;
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
    private Double quantity_available;
    @ManyToMany(mappedBy = "products")
    private List<Sale> sales;
}
