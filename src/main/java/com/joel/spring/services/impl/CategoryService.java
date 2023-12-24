package com.joel.spring.services.impl;

import com.joel.spring.entities.Category;
import com.joel.spring.exceptions.NotFoundException;
import com.joel.spring.repositories.ICategoryRepository;
import com.joel.spring.services.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CategoryService implements ICategoryService {
    @Autowired private ICategoryRepository categoryRepository;
    @Override
    public List<Category> getListCategoriesById(List<String> categoriesId) {
        List<Category> categories = new ArrayList<>();
        for (String id : categoriesId) {
            try {
                categories.add(this.getCategoryById(id));
            } catch (NotFoundException e) {
                continue;
            }
        }
        return categories;
    }

    @Override
    public Category getCategoryById(String id) throws NotFoundException {
        Optional<Category> optional = this.categoryRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new NotFoundException("Category not found");
    }
}
