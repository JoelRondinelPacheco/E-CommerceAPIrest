package com.joel.spring.category.application.port.input;

import com.joel.spring.category.domain.Category;
import com.joel.spring.dtos.categories.CategoryInfoDTO;
import com.joel.spring.dtos.categories.CategoryParentInfoDTO;
import com.joel.spring.category.adapter.output.persistence.CategoryEntity;
import com.joel.spring.exceptions.NotFoundException;

import java.util.ArrayList;
import java.util.List;

public interface CategoryService {
    List<Category> categoriesById(List<String> categoriesId);
    Category getCategoryById(String id) throws NotFoundException;
    public List<CategoryInfoDTO> categoryInfoDTOList(String parentId);
    public CategoryParentInfoDTO categoryParentInfoDTO(String id) throws NotFoundException;
    public List<CategoryParentInfoDTO> categoryParentInfoDTOList(List<String> categories);
    List<CategoryParentInfoDTO> categoryParentInfoDTOListByProductId(String id);
    List<String> categoriesIdByProduct(String productId);
}
