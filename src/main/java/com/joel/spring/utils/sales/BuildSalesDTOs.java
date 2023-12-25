package com.joel.spring.utils.sales;

import com.joel.spring.dtos.sales.SaleInfoDTO;
import com.joel.spring.entities.Sale;
import com.joel.spring.utils.products.BuildProductsDTOs;
import com.joel.spring.utils.users.BuildUsersDTOs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuildSalesDTOs {
    @Autowired private BuildUsersDTOs usersDTOs;
    @Autowired private BuildProductsDTOs productsDTOs;

    public SaleInfoDTO saleInfoDTO(Sale sale) {
        return SaleInfoDTO.builder()
                .saleId(sale.getId())
                .totalPrice(sale.getTotalPrice())
                .client(this.usersDTOs.userPersonalInfoDTO(sale.getClient()))
                .products(this.productsDTOs.productInfoDTOList(sale.getProducts()))
                .build();
    }
}
