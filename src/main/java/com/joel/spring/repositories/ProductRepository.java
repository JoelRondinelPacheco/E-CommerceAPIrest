package com.joel.spring.repositories;

import com.joel.spring.dtos.products.ProductInfoDTO;
import com.joel.spring.entities.Product;
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
public interface ProductRepository extends JpaRepository<Product, String> {
    @Modifying
    @Query("UPDATE Product p SET p.stock = p.stock - :quantity WHERE p.id = :id")
    int updateQuantity(@Param("id") String id, @Param("quantity") Double quantity);
    @Query("SELECT new com.joel.spring.dtos.products.ProductInfoDTO(p.id, p.name, p.brand, p.price, p.stock) FROM Product p WHERE p.stock < :max")
    List<ProductInfoDTO> getLowStock (@Param("max") Long max);

    @Query("SELECT new com.joel.spring.dtos.products.ProductInfoDTO(p.id, p.name, p.brand, p.price, p.stock) FROM Product p")
    List<ProductInfoDTO> getAllDTOs();


    @Query("SELECT new com.joel.spring.dtos.products.ProductInfoDTO(p.id, p.name, p.brand, p.price, p.stock) FROM Product p WHERE p.id = :productId")
    Optional<ProductInfoDTO> getDTOById(@Param("productId") String productId);
    @Query("SELECT new com.joel.spring.dtos.products.ProductInfoDTO(p.id, p.name, p.brand, p.price, p.stock) FROM Product p JOIN Sale s WHERE s.id = :saleId")
    List<ProductInfoDTO> getProductInfoBySaleId(@Param("saleId") String saleId);
}
