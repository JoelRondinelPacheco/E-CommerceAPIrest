package com.joel.spring.cartproduct.adapter.output.persistence;

import com.joel.spring.cartproduct.adapter.output.persistence.CartProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartProductRepository extends JpaRepository<CartProductEntity, String> {

    Optional<CartProductEntity> findByCart_Id(String cartId);
}
