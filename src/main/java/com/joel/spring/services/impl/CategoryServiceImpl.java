package com.joel.spring.services.impl;

import com.joel.spring.dtos.categories.CategoryInfoDTO;
import com.joel.spring.dtos.categories.CategoryParentInfoDTO;
import com.joel.spring.category.adapter.output.persistence.CategoryEntity;
import com.joel.spring.exceptions.NotFoundException;
import com.joel.spring.category.adapter.output.persistence.CategoryRepository;
import com.joel.spring.category.application.port.input.CategoryService;
import com.joel.spring.utils.CheckOptional;
import com.joel.spring.utils.categories.BuildCategoryDTOs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl  {
    @Autowired private CategoryRepository categoryRepository;
    @Autowired private CheckOptional checkOptional;
    @Autowired private BuildCategoryDTOs categoryDTOs;
    public List<CategoryEntity> getListCategoriesById(List<String> categoriesId) {
        List<CategoryEntity> categories = new ArrayList<>();
        for (String id : categoriesId) {
            try {
                categories.add(this.getCategoryById(id));
            } catch (NotFoundException e) {
                continue;
            }
        }
        return categories;
    }

    public CategoryEntity getCategoryById(String id) throws NotFoundException {
        Optional<CategoryEntity> optional = this.categoryRepository.findById(id);
       return this.checkOptional.checkOptionalOk(optional);
    }

    public List<CategoryInfoDTO> categoryInfoDTOList(String parentId) {
        return this.categoryRepository.categoryInfoDTOByParentId(parentId);
    }
    public CategoryParentInfoDTO categoryParentInfoDTO(String id) throws NotFoundException {
        Optional<CategoryInfoDTO> optional = this.categoryRepository.categoryInfoDTOById(id);
        //Info de parent
        CategoryInfoDTO parentInfo =  this.checkOptional.checkOptionalOk(optional);
        List<CategoryInfoDTO> children = this.categoryInfoDTOList(id);
        return CategoryParentInfoDTO.builder()
                .id(parentInfo.getId())
                .name(parentInfo.getName())
                .categoryOrder(parentInfo.getCategoryOrder())
                .children(children)
                .build();
    }

    public List<CategoryParentInfoDTO> categoryParentInfoDTOList(List<String> categories) {
        List<CategoryParentInfoDTO> categoriesDTO = new ArrayList<>();
        for (String id : categories) {
            try {
                categoriesDTO.add(this.categoryParentInfoDTO(id));
            } catch (NotFoundException e) {
                continue;
            }
        }
        return categoriesDTO;
    }

    public List<CategoryParentInfoDTO> categoryParentInfoDTOListByProductId(String id) {
        List<String> categoriesId = this.categoriesIdByProduct(id);
        return this.categoryParentInfoDTOList(categoriesId);
    }

    public List<String> categoriesIdByProduct(String productId) {
        return this.categoryRepository.getCategoriesIdByProductId(productId);
    }


}
