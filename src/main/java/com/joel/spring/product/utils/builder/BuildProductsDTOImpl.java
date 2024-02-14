package com.joel.spring.product.utils.builder;


import com.joel.spring.dtos.categories.CategoryParentInfoDTO;
import com.joel.spring.product.domain.Product;
import com.joel.spring.product.application.dto.ProductInfoDTO;
import com.joel.spring.utils.categories.BuildCategoryDTOs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BuildProductsDTOImpl implements BuildProductsDTO {

    @Autowired private BuildCategoryDTOs categoryDTOs;
    public ProductInfoDTO productInfoDTO(Product product) {
      /*  List<CategoryParentInfoDTO> categories = this.categoryDTOs.categoryParentInfoDTOList(product.getCategories());
        return ProductInfoDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .brand(product.getBrand())
                .price(product.getPrice())
                .stock(product.getStock())
                .categories(categories)
                .build();*/
        return null;
    }

    public List<ProductInfoDTO> productInfoDTOList(List<Product> products) {
        List<ProductInfoDTO> dto = new ArrayList<>();
        for (Product p : products) {
            dto.add(this.productInfoDTO(p));
        }
        return dto;
    }
}
