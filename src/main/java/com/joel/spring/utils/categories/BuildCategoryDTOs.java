package com.joel.spring.utils.categories;

import com.joel.spring.category.application.dto.CategoryInfoDTO;
import com.joel.spring.category.adapter.output.persistence.entity.CategoryEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BuildCategoryDTOs {
    /*
    public CategoryInfoDTO categoryParentInfoDTO(CategoryEntity categoryEntity) {
        List<CategoryInfoDTO> children = this.categoryInfoDTOSList(categoryEntity.getChildren());
        return CategoryInfoDTO.builder()
                .id(categoryEntity.getId())
                .name(categoryEntity.getName())
                .categoryOrder(categoryEntity.getDisplayOrder())
                .children(children)
                .build();
    }

    public List<CategoryInfoDTO> categoryParentInfoDTOList(List<CategoryEntity> categories) {
        List<CategoryInfoDTO> categoriesDTO = new ArrayList<>();
        for (CategoryEntity categoryEntity : categories) {
            categoriesDTO.add(this.categoryParentInfoDTO(categoryEntity));
        }
        return categoriesDTO;
    }

    public CategoryInfoDTO categoryInfoDTO(CategoryEntity categoryEntity) {
        return CategoryInfoDTO.builder()
                .id(categoryEntity.getId())
                .name(categoryEntity.getName())
                .categoryOrder(categoryEntity.getDisplayOrder())
                .build();
    }

    public List<CategoryInfoDTO> categoryInfoDTOSList(List<CategoryEntity> categories) {
        List<CategoryInfoDTO> children = new ArrayList<>();
        for (CategoryEntity categoryEntity : categories) {
            children.add(this.categoryInfoDTO(categoryEntity));
        }
        return children;
    }*/
}
