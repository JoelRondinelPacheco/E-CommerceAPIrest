package com.joel.spring.category.application.port.outpout;

import com.joel.spring.category.domain.Category;

import java.util.List;

public interface CategorySelectorPort {
    Category getById(String id);
    List<Category> getCategoriesByIds(List<String> ids);
}
