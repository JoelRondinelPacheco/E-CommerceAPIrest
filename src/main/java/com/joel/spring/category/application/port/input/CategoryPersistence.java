package com.joel.spring.category.application.port.input;

import com.joel.spring.category.application.dto.NewCategoryDTO;
import com.joel.spring.category.domain.Category;

public interface CategoryPersistence {
    Category newCategory(NewCategoryDTO categoryDTO);
}
