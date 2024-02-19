package com.joel.spring.cart.adapter.out.persistence.entity;

import com.joel.spring.cartproduct.adapter.output.persistence.CartProductEntity;
import com.joel.spring.user.adapter.output.persistence.UserEntity;
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


    @OneToMany(mappedBy = "cart", fetch = FetchType.LAZY)
    private List<CartProductEntity> products;

    @OneToOne(mappedBy = "cart", fetch = FetchType.LAZY)
    private UserEntity user;

}
