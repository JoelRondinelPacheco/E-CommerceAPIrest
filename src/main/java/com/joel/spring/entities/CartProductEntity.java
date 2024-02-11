package com.joel.spring.entities;

import com.joel.spring.cart.adapter.out.persistence.entity.CartEntity;
import com.joel.spring.product.adapter.out.persistence.ProductEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "cart_products")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CartProductEntity {
    @Id
    @UuidGenerator
    private String id;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private CartEntity cart;
}
