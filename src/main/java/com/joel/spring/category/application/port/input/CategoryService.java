package com.joel.spring.category.application.port.input;

import com.joel.spring.category.domain.Category;
import com.joel.spring.category.application.dto.CategoryInfoDTO;

import java.util.List;

public interface CategoryService {
    List<Category> categoriesById(List<String> categoriesId);
    public List<CategoryInfoDTO> categoryInfoDTOList(String parentId);
    public CategoryInfoDTO categoryParentInfoDTO(String id);
    public List<CategoryInfoDTO> categoryParentInfoDTOList(List<String> categories);
    List<CategoryInfoDTO> categoryParentInfoDTOListByProductId(String id);
    List<String> categoriesIdByProduct(String productId);
}
