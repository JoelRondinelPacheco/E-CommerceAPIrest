package com.joel.spring.sales.adapter.output.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleDTOsJpaMySQLRepository extends JpaRepository<SaleEntity, String> {
    /*

    TODO DO DTO
    @Query("SELECT new com.joel.spring.sales.dto.SaleInfoDTO(s.id, s.totalPrice," +
            " new com.joel.spring.user.dto.UserPersonalInfoDTO(u.id, u.firstName, u.lastName, u.email)) FROM SaleEntity s JOIN UserEntity u")
    List<SaleInfoDTO> getAllSalesDTOs();
    @Query("SELECT new com.joel.spring.sales.dto.SaleInfoDTO(s.id, s.totalPrice, " +
            "new com.joel.spring.user.dto.UserPersonalInfoDTO(u.id, u.firstName, u.lastName, u.email), " +
            "new com.joel.spring.product.dto.ProductInfoDTO(p.id, p.name)) " +
            "FROM SaleEntity s JOIN UserEntity u ON s.user = u JOIN ProductEntity p ON u.product = p")
    List<SaleInfoDTO> getAllSalesDTOs();


    @Query("SELECT new com.joel.spring.sales.dto.SaleInfoDTO(s.id, s.totalPrice, " +
            "new com.joel.spring.user.dto.UserPersonalInfoDTO(u.id, u.firstName, u.lastName, u.email)) " +
            "FROM SaleEntity s JOIN UserEntity u ON s.userId = u.id")
    List<SaleInfoDTO> getAllSalesDTOs();
*/
}
