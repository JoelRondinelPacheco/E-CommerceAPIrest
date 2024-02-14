package com.joel.spring.sales.adapter.output.persistence;

import com.joel.spring.sales.dto.SaleInfoDTO;
import com.joel.spring.sales.dto.SaleMaxAmountDTO;
import com.joel.spring.product.adapter.out.persistence.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface JpaMySQLSaleRepository extends JpaRepository<SaleEntity, String >{
    @Query("SELECT s.products FROM SaleEntity s WHERE s.id = :saleId")
    List<ProductEntity> findProductsBySaleId(@Param("saleId") String saleId);
    @Query("SELECT saleEntities FROM SaleEntity saleEntities WHERE saleEntities.saleDate = :saleDate")
    List<SaleEntity> getSaleByDate(@Param("saleDate") Date saleDate);
    @Query("SELECT COUNT(sale) FROM SaleEntity sale WHERE sale.saleDate = :saleDate")
    int countSalesByDate(@Param("saleDate") Date saleDate);
    @Query("SELECT SUM(s.totalPrice) FROM SaleEntity s WHERE s.saleDate = :saleDate")
    Double totalAmountByDate(@Param("saleDate") Date saleDate);
    @Query("SELECT s.id AS saleId, s.totalPrice AS totalPrice, c.firstName AS name, c.lastName AS lastName FROM SaleEntity s INNER JOIN UserEntity c ON s.client.id = c.id WHERE s.totalPrice = (SELECT MAX(totalPrice) FROM SaleEntity)")
    List<SaleMaxAmountDTO> saleMaxAmount();

    @Query("SELECT new com.joel.spring.dtos.saleEntities.SaleInfoDTO(s.id, s.totalPrice," +
            " new com.joel.spring.user.dto.UserPersonalInfoDTO(u.id, u.firstName, u.lastName, u.email)) FROM SaleEntity s JOIN UserEntity u")
    List<SaleInfoDTO> getAllSalesDTOs();

    @Query("SELECT new com.joel.spring.dtos.saleEntities.SaleInfoDTO(s.id, s.totalPrice," +
            " new com.joel.spring.user.dto.UserPersonalInfoDTO(u.id, u.firstName, u.lastName, u.email)) FROM SaleEntity s JOIN UserEntity u WHERE s.id =:saleId")
    Optional<SaleInfoDTO> getSaleByIdDTO(@Param(("saleId")) String saleId);
}
