package com.joel.spring.cartproduct.adapter.output.persistence;

import com.joel.spring.cartproduct.application.dto.ProductCartInfoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartProductDTOMySQLRepository extends JpaRepository<CartProductEntity, String> {

    List<ProductCartInfoDTO> findByCart_User_Id(String userId);
}
