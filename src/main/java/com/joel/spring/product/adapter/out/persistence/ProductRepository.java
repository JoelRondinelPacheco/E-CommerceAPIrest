package com.joel.spring.product.adapter.out.persistence;

import com.joel.spring.product.dto.ProductInfoDTO;
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
    @Query("SELECT new com.joel.spring.dtos.products.ProductCartInfoDTO(p.id, p.name, p.brand, p.price, p.stock) FROM ProductEntity p WHERE p.stock < :max")
    List<ProductInfoDTO> getLowStock (@Param("max") Long max);

    @Query("SELECT new com.joel.spring.dtos.products.ProductCartInfoDTO(p.id, p.name, p.brand, p.price, p.stock) FROM ProductEntity p")
    List<ProductInfoDTO> getAllDTOs();


    @Query("SELECT new com.joel.spring.dtos.products.ProductCartInfoDTO(p.id, p.name, p.brand, p.price, p.stock) FROM ProductEntity p WHERE p.id = :productId")
    Optional<ProductInfoDTO> getDTOById(@Param("productId") String productId);
    @Query("SELECT new com.joel.spring.dtos.products.ProductCartInfoDTO(p.id, p.name, p.brand, p.price, p.stock) FROM ProductEntity p JOIN SaleEntity s WHERE s.id = :saleId")
    List<ProductInfoDTO> getProductInfoBySaleId(@Param("saleId") String saleId);
}
