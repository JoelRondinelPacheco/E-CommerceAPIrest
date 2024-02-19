package com.joel.spring.category.application.usecases;

import com.joel.spring.category.application.port.input.CategorySelector;
import com.joel.spring.category.application.port.outpout.CategorySelectorPort;
import com.joel.spring.category.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CategoryById implements CategorySelector<String> {
    @Autowired
    @Qualifier("categoryById")
    private CategorySelectorPort categoryRepository;
    @Override
    public Category get(String categoryId) {
        return this.categoryRepository.getById(categoryId);
    }
}
