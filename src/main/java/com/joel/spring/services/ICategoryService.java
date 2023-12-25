package com.joel.spring.services;

import com.joel.spring.dtos.categories.CategoryInfoDTO;
import com.joel.spring.dtos.categories.CategoryParentInfoDTO;
import com.joel.spring.entities.Category;
import com.joel.spring.exceptions.NotFoundException;

import java.util.List;

public interface ICategoryService {
    List<Category> getListCategoriesById(List<String> categoriesId);
    Category getCategoryById(String id) throws NotFoundException;
    public List<CategoryInfoDTO> categoryInfoDTOList(String parentId);
    public CategoryParentInfoDTO categoryParentInfoDTO(String id) throws NotFoundException;
    public List<CategoryParentInfoDTO> categoryParentInfoDTOList(List<String> categories);
    List<CategoryParentInfoDTO> categoryParentInfoDTOListByProductId(String id);
    List<String> categoriesIdByProduct(String productId);
}
