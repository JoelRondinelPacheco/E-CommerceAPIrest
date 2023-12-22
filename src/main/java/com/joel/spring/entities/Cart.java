package com.joel.spring.entities;

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
public class Cart {
    @Id
    @UuidGenerator
    private String id;
    private Double totalPrice;


    @OneToMany(mappedBy = "cart", fetch = FetchType.LAZY)
    private List<CartProduct> cartProducts;

    @OneToOne(mappedBy = "cart")
    private UserEntity user;

}
