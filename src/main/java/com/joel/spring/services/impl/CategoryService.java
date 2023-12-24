package com.joel.spring.services.impl;

import com.joel.spring.dtos.categories.CategoryInfoDTO;
import com.joel.spring.dtos.categories.CategoryParentInfoDTO;
import com.joel.spring.entities.Category;
import com.joel.spring.exceptions.NotFoundException;
import com.joel.spring.repositories.ICategoryRepository;
import com.joel.spring.services.ICategoryService;
import com.joel.spring.utils.CheckOptional;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryService implements ICategoryService {
    @Autowired private ICategoryRepository categoryRepository;
    @Autowired private CheckOptional checkOptional;
    @Override
    public List<Category> getListCategoriesById(List<String> categoriesId) {
        List<Category> categories = new ArrayList<>();
        for (String id : categoriesId) {
            try {
                categories.add(this.getCategoryById(id));
            } catch (NotFoundException e) {
                continue;
            }
        }
        return categories;
    }

    @Override
    public Category getCategoryById(String id) throws NotFoundException {
        Optional<Category> optional = this.categoryRepository.findById(id);
       return this.checkOptional.checkOptionalOk(optional);
    }

    @Override
    public CategoryParentInfoDTO categoryInfoDTO(String id) throws NotFoundException {
        Optional<CategoryInfoDTO> optional = this.categoryRepository.categoryInfoDTOById(id);
        //Info de parent
        CategoryInfoDTO parentInfo =  this.checkOptional.checkOptionalOk(optional);
        List<CategoryInfoDTO> children = this.categoryRepository.categoryInfoDTOByParentId(id);
        return CategoryParentInfoDTO.builder()
                .id(parentInfo.getId())
                .name(parentInfo.getName())
                .categoryOrder(parentInfo.getCategoryOrder())
                .children(children)
                .build();

    }

}
