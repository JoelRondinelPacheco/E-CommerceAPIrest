package com.joel.spring.services.impl;

import com.joel.spring.dtos.categories.CategoryParentInfoDTO;
import com.joel.spring.product.dto.ProductEditReqDTO;
import com.joel.spring.product.dto.ProductInfoDTO;
import com.joel.spring.product.dto.ProductPostReqDTO;
import com.joel.spring.category.adapter.output.persistence.CategoryEntity;
import com.joel.spring.product.adapter.out.persistence.ProductEntity;
import com.joel.spring.exceptions.NotFoundException;
import com.joel.spring.product.adapter.out.persistence.ProductRepository;
import com.joel.spring.category.application.port.input.CategoryService;
import com.joel.spring.utils.CheckOptional;
import com.joel.spring.utils.categories.BuildCategoryDTOs;
import com.joel.spring.utils.products.BuildProductsDTOs;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl{
    @Autowired private ProductRepository productRepository;
    @Autowired private CategoryService categoryService;
    @Autowired private BuildCategoryDTOs categoryDTOs;
    @Autowired private CheckOptional checkOptional;
    @Autowired private BuildProductsDTOs productsDTOs;





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
