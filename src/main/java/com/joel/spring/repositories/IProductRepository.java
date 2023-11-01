package com.joel.spring.repositories;

import com.joel.spring.entities.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface IProductRepository extends JpaRepository<Product, Long> {
    @Modifying
    @Query("UPDATE Product p SET p.quantity_available = p.quantity_available - :quantity WHERE p.product_id = :id")
    int updateQuantity(@Param("id") Long id, @Param("quantity") Double quantity);
    @Query("SELECT p FROM Product p WHERE p.quantity_available < :max")
    List<Product> getLackStock (@Param("max") Long quantity);
}
