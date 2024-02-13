package com.joel.spring.category.application.port.input;

import com.joel.spring.category.domain.Category;

import java.util.List;

public interface CategoryService {
    List<Category> categoriesById(List<String> categoriesId);
}
