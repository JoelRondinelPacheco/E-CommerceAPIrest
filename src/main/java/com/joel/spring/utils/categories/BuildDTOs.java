package com.joel.spring.utils.categories;

import com.joel.spring.dtos.categories.CategoryInfoDTO;
import com.joel.spring.dtos.categories.CategoryParentInfoDTO;
import com.joel.spring.entities.Category;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BuildDTOs {
    public CategoryParentInfoDTO categoryInfoDTO(Category category) {
        List<CategoryInfoDTO> children = this.categoryChildrenInfoDTOSList(category.getChildren());
        return CategoryParentInfoDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .categoryOrder(category.getCategoryOrder())
                .children(children)
                .build();
    }

    public CategoryInfoDTO categoryChildrenInfoDTO(Category category) {
        return CategoryInfoDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .categoryOrder(category.getCategoryOrder())
                .build();
    }

    public List<CategoryInfoDTO> categoryChildrenInfoDTOSList(List<Category> categories) {
        List<CategoryInfoDTO> children = new ArrayList<>();
        for (Category category : categories) {
            children.add(this.categoryChildrenInfoDTO(category));
        }
        return children;
    }
}
