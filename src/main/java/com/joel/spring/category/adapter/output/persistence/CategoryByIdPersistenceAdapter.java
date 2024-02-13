package com.joel.spring.category.adapter.output.persistence;

import com.joel.spring.category.application.port.outpout.CategorySelectorPort;
import com.joel.spring.category.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("categoryById")
public class CategoryByIdPersistenceAdapter implements CategorySelectorPort {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public Category get(String id) {
        //TODO CREATE METHOD
        return null;
    }
}
