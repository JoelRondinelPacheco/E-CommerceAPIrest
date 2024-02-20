package com.joel.spring.category.application.usecases;

import com.joel.spring.category.application.dto.NewCategoryDTO;
import com.joel.spring.category.application.dto.NewSubCategory;
import com.joel.spring.category.application.port.input.CategoryPersistence;
import com.joel.spring.category.application.port.outpout.CategoryPersistencePort;
import com.joel.spring.category.domain.Category;
import com.joel.spring.category.domain.SubCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryPersistenceImpl implements CategoryPersistence {

    @Autowired
    private CategoryPersistencePort categoryRepository;

    @Override
    public Category newCategory(NewCategoryDTO categoryDTO) {
        //TODO CHECK EXISTING CATEGORY

        //TODO REFACTOR CATEGORIES BUILDER
        List<SubCategory> subCategories = new ArrayList<>();

        for (NewSubCategory s : categoryDTO.getSubCategories()) {
            subCategories.add(
                    SubCategory.builder()
                            .name(s.getName())
                            .build()
            );
        }

        Category category = Category.builder()
                .name(categoryDTO.getName())
                .description(categoryDTO.getDescription())
                .subCategories(subCategories)
                .build();
        System.out.println(category);

        return this.categoryRepository.save(category);

    }
}
