package com.joel.spring.product.adapter.out.persistence;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.joel.spring.cartproduct.adapter.output.persistence.CartProductEntity;
import com.joel.spring.category.adapter.output.persistence.entity.CategoryEntity;
import com.joel.spring.sales.adapter.output.persistence.SaleEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
@JsonIgnoreProperties("saleEntities")
public class ProductEntity {
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
    private Long stock;

    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
    private List<SaleEntity> sales;

    @ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
    private List<CategoryEntity> categories;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<CartProductEntity> cartsProducts;
}
