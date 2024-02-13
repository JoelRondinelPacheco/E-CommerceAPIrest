package com.joel.spring.cart.adapter.out.persistence.repository;

import com.joel.spring.cart.adapter.out.persistence.cartproduct.CartProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartProductRepository extends JpaRepository<CartProductEntity, String> {

    Optional<CartProductEntity> findByCart_Id(String cartId);
}
