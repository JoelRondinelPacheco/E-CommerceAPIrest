package com.joel.spring.services.impl;

import com.joel.spring.dtos.categories.CategoryParentInfoDTO;
import com.joel.spring.product.application.dto.ProductInfoDTO;
import com.joel.spring.product.adapter.out.persistence.ProductRepository;
import com.joel.spring.category.application.port.input.CategoryService;
import com.joel.spring.utils.CheckOptional;
import com.joel.spring.utils.categories.BuildCategoryDTOs;
import com.joel.spring.product.utils.builder.BuildProductsDTOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl{
    @Autowired private ProductRepository productRepository;
    @Autowired private CategoryService categoryService;
    @Autowired private BuildCategoryDTOs categoryDTOs;
    @Autowired private CheckOptional checkOptional;
    @Autowired private BuildProductsDTOImpl productsDTOs;





    public int updateQuantity(String id, Double quantity){
    return this.productRepository.updateQuantity(id, quantity);
    }


    public List<ProductInfoDTO> getLowStock (Long quantity) {
        return this.productRepository.getLowStock(quantity);
    }


    public List<ProductInfoDTO> getAllDTO() {
        List<ProductInfoDTO> list = this.productRepository.getAllDTOs();
        for (ProductInfoDTO product : list) {
            List<String> categories = this.categoryService.categoriesIdByProduct(product.getId());
            List<CategoryParentInfoDTO> categoriesInfo = this.categoryService.categoryParentInfoDTOList(categories);
            product.setCategories(categoriesInfo);
        }
        return list;
    }


    public List<ProductInfoDTO> getProductInfoBySaleId(String saleId) {
        return this.productRepository.getProductInfoBySaleId(saleId);
    }

}
