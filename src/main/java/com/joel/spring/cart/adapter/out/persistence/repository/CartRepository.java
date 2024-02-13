package com.joel.spring.cart.adapter.out.persistence.repository;

import com.joel.spring.cart.adapter.out.persistence.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, String> {


    Optional<CartEntity> findByUser_Id(String userId);

    /*
    @Query("SELECT cartEntity*id FROM CartRepository cartEntity WHERE cartEntity.user.id = :userId")
    Optional<String> getCartId(@Param("userId") String userId);*/
}
