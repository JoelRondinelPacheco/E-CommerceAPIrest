package com.joel.spring.utils.products;


import com.joel.spring.dtos.categories.CategoryParentInfoDTO;
import com.joel.spring.product.dto.ProductInfoDTO;
import com.joel.spring.product.adapter.out.persistence.ProductEntity;
import com.joel.spring.utils.categories.BuildCategoryDTOs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BuildProductsDTOs {

    @Autowired private BuildCategoryDTOs categoryDTOs;
    public ProductInfoDTO productInfoDTO(ProductEntity productEntity) {
        List<CategoryParentInfoDTO> categories = this.categoryDTOs.categoryParentInfoDTOList(productEntity.getCategories());
        return ProductInfoDTO.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .brand(productEntity.getBrand())
                .price(productEntity.getPrice())
                .stock(productEntity.getStock())
                .categories(categories)
                .build();
    }

    public List<ProductInfoDTO> productInfoDTOList(List<ProductEntity> productEntities) {
        List<ProductInfoDTO> dto = new ArrayList<>();
        for (ProductEntity p : productEntities) {
            dto.add(this.productInfoDTO(p));
        }
        return dto;
    }
}
