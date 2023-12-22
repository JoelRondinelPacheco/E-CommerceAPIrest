package com.joel.spring.repositories;

import com.joel.spring.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICartRepository extends JpaRepository<Cart, String> {


    Optional<Cart> findByUser_Id(String userId);

    /*
    @Query("SELECT cart*id FROM CartRepository cart WHERE cart.user.id = :userId")
    Optional<String> getCartId(@Param("userId") String userId);*/
}
