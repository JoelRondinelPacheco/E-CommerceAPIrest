package com.joel.spring.repositories;

import com.joel.spring.dtos.sales.SaleMaxAmountDTO;
import com.joel.spring.entities.Product;
import com.joel.spring.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface ISaleRepository extends JpaRepository<Sale, Long >{
    @Query("SELECT s.products FROM Sale s WHERE s.id = :saleId")
    List<Product> findProductsBySaleId(@Param("saleId") Long saleId);
    @Query("SELECT sales FROM Sale sales WHERE sales.sale_date = :saleDate")
    List<Sale> getSaleByDate(@Param("saleDate") Date saleDate);
    @Query("SELECT COUNT(sale) FROM Sale sale WHERE sale.sale_date = :saleDate")
    int countSalesByDate(@Param("saleDate") Date saleDate);
    @Query("SELECT SUM(s.total_price) FROM Sale s WHERE s.sale_date = :saleDate")
    Double totalAmountByDate(@Param("saleDate") Date saleDate);
    @Query("SELECT s.sale_id AS saleId, s.total_price AS totalPrice, c.name AS name, c.lastname AS lastName FROM Sale s INNER JOIN UserEntity c ON s.client.client_id = c.client_id WHERE s.total_price = (SELECT MAX(total_price) FROM Sale)")
    List<SaleMaxAmountDTO> saleMaxAmount();
}
