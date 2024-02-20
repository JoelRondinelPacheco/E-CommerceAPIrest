package com.joel.spring.category.adapter.output.persistence.mapper;

import com.joel.spring.category.adapter.output.persistence.entity.CategoryEntity;
import com.joel.spring.category.domain.Category;
import com.joel.spring.category.domain.SubCategory;
import com.joel.spring.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Qualifier("categoryMapper")
public class CategoryMapper implements Mapper<CategoryEntity, Category> {

    @Autowired
    private SubCategoryMapper subCategoryMapper;

    @Override
    public Category entityToDomain(CategoryEntity categoryEntity) {
        List<SubCategory> subCategories = this.subCategoryMapper.entityToDomainList(categoryEntity.getSubCategories());

        Category category = Category.builder()
                .id(categoryEntity.getId())
                .name(categoryEntity.getName())
                .description(categoryEntity.getDescription())
                .subCategories(subCategories)
                .build();

        return category;
    }

    @Override
    public CategoryEntity domainToEntity(Category category) {
        CategoryEntity categoryEntity = new CategoryEntity().builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .subCategories(this.subCategoryMapper.domaintToEntityList(category.getSubCategories()))
                .build();

        return categoryEntity;
    }
}
