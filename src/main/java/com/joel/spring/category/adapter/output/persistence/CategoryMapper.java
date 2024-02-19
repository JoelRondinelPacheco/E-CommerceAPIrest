package com.joel.spring.category.adapter.output.persistence;

import com.joel.spring.category.domain.Category;
import com.joel.spring.utils.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("categoryMapper")
public class CategoryMapper implements Mapper<CategoryEntity, Category> {
    @Override
    public Category entityToDomain(CategoryEntity categoryEntity) {
        return null;
    }

    @Override
    public CategoryEntity domainToEntity(Category category) {
        return null;
    }
}
