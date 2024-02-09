package com.joel.spring.entities;

import com.joel.spring.user.infrastructure.output.persistence.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity
@Table(name = "carts")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CartEntity {
    @Id
    @UuidGenerator
    private String id;
    private Double totalPrice;


    @OneToMany(mappedBy = "cartEntity", fetch = FetchType.LAZY)
    private List<CartProductEntity> products;

    @OneToOne(mappedBy = "cartEntity")
    private UserEntity user;

}