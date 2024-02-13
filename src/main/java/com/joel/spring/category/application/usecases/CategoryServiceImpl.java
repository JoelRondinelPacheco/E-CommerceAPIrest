package com.joel.spring.category.application.usecases;

import com.joel.spring.category.adapter.output.persistence.CategoryEntity;
import com.joel.spring.category.domain.Category;
import com.joel.spring.dtos.categories.CategoryInfoDTO;
import com.joel.spring.dtos.categories.CategoryParentInfoDTO;
import com.joel.spring.exceptions.NotFoundException;
import com.joel.spring.category.application.port.input.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired

    @Override
    public List<Category> categoriesById(List<String> categoriesId) {
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
        return null;
    }

    @Override
    public List<CategoryInfoDTO> categoryInfoDTOList(String parentId) {
        return null;
    }

    @Override
    public CategoryParentInfoDTO categoryParentInfoDTO(String id) throws NotFoundException {
        return null;
    }

    @Override
    public List<CategoryParentInfoDTO> categoryParentInfoDTOList(List<String> categories) {
        return null;
    }

    @Override
    public List<CategoryParentInfoDTO> categoryParentInfoDTOListByProductId(String id) {
        return null;
    }

    @Override
    public List<String> categoriesIdByProduct(String productId) {
        return null;
    }
}
