package com.joel.spring.category.application.port.outpout;

import com.joel.spring.category.application.dto.NewCategoryDTO;
import com.joel.spring.category.domain.Category;

public interface CategoryPersistencePort {
    Category save(Category category);

}
