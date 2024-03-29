package com.joel.spring.product.adapter.out.persistence;

import com.joel.spring.product.application.dto.ProductInfoDTO;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface ProductRepository extends JpaRepository<ProductEntity, String> {
    @Modifying
    @Query("UPDATE ProductEntity p SET p.stock = p.stock - :quantity WHERE p.id = :id")
    int updateQuantity(@Param("id") String id, @Param("quantity") Double quantity);


    @Modifying
    @Query("UPDATE ProductEntity p SET p.stock = :stock WHERE p.id = :id")
    int updateStock(@Param("id") String id, @Param("stock") Long stock);

}
