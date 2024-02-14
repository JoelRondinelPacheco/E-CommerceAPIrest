package com.joel.spring.utils.sales;

import com.joel.spring.sales.dto.SaleInfoDTO;
import com.joel.spring.sales.adapter.output.persistence.SaleEntity;
import com.joel.spring.product.utils.builder.BuildProductsDTOImpl;
import com.joel.spring.utils.users.BuildUsersDTOs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuildSalesDTOs {
    @Autowired private BuildUsersDTOs usersDTOs;
    @Autowired private BuildProductsDTOImpl productsDTOs;

    public SaleInfoDTO saleInfoDTO(SaleEntity saleEntity) {
        return SaleInfoDTO.builder()
                .saleId(saleEntity.getId())
                .totalPrice(saleEntity.getTotalPrice())
                .client(this.usersDTOs.userPersonalInfoDTO(saleEntity.getClient()))
                .products(this.productsDTOs.productInfoDTOList(saleEntity.getProductEntities()))
                .build();
    }
}
