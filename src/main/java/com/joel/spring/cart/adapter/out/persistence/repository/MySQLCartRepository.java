package com.joel.spring.cart.adapter.out.persistence.repository;

import com.joel.spring.cart.adapter.out.persistence.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MySQLCartRepository extends JpaRepository<CartEntity, String> {
}
