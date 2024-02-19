package com.joel.spring.category.application.port.input;

import com.joel.spring.category.domain.Category;
import com.joel.spring.category.application.dto.CategoryInfoDTO;
import com.joel.spring.category.application.dto.CategoryParentInfoDTO;
import com.joel.spring.exceptions.NotFoundException;

import java.util.List;

public interface CategoryService {
    List<Category> categoriesById(List<String> categoriesId);
    public List<CategoryInfoDTO> categoryInfoDTOList(String parentId);
    public CategoryParentInfoDTO categoryParentInfoDTO(String id);
    public List<CategoryParentInfoDTO> categoryParentInfoDTOList(List<String> categories);
    List<CategoryParentInfoDTO> categoryParentInfoDTOListByProductId(String id);
    List<String> categoriesIdByProduct(String productId);
}
