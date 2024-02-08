package com.joel.spring.utils.categories;

import com.joel.spring.dtos.categories.CategoryInfoDTO;
import com.joel.spring.dtos.categories.CategoryParentInfoDTO;
import com.joel.spring.entities.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BuildCategoryDTOs {
    public CategoryParentInfoDTO categoryParentInfoDTO(Category category) {
        List<CategoryInfoDTO> children = this.categoryInfoDTOSList(category.getChildren());
        return CategoryParentInfoDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .categoryOrder(category.getDisplayOrder())
                .children(children)
                .build();
    }

    public List<CategoryParentInfoDTO> categoryParentInfoDTOList(List<Category> categories) {
        List<CategoryParentInfoDTO> categoriesDTO = new ArrayList<>();
        for (Category category : categories) {
            categoriesDTO.add(this.categoryParentInfoDTO(category));
        }
        return categoriesDTO;
    }

    public CategoryInfoDTO categoryInfoDTO(Category category) {
        return CategoryInfoDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .categoryOrder(category.getDisplayOrder())
                .build();
    }

    public List<CategoryInfoDTO> categoryInfoDTOSList(List<Category> categories) {
        List<CategoryInfoDTO> children = new ArrayList<>();
        for (Category category : categories) {
            children.add(this.categoryInfoDTO(category));
        }
        return children;
    }
}
