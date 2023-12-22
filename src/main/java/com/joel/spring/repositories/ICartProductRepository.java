package com.joel.spring.repositories;

import com.joel.spring.entities.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICartProductRepository extends JpaRepository<CartProduct, String> {

    Optional<CartProduct> findByCart_Id(String cartId);
}
