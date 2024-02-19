package com.joel.spring.category.adapter.output.persistence;

import com.joel.spring.category.adapter.output.persistence.entity.CategoryEntity;
import com.joel.spring.category.adapter.output.persistence.mapper.CategoryMapper;
import com.joel.spring.category.adapter.output.persistence.mapper.SubCategoryMapper;
import com.joel.spring.category.application.dto.NewCategoryDTO;
import com.joel.spring.category.application.port.outpout.CategoryPersistencePort;
import com.joel.spring.category.domain.Category;
import com.joel.spring.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryPersistenceAdapter implements CategoryPersistencePort {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SubCategoryMapper subCategoryMapper;

    @Autowired
    @Qualifier("categoryMapper")
    private Mapper<CategoryEntity, Category> categoryMapper;

    @Override
    public Category save(Category category) {

        CategoryEntity categoryEntity = this.categoryMapper.domainToEntity(category);
        CategoryEntity categoryEntitySaved = this.categoryRepository.save(categoryEntity);

        return this.categoryMapper.entityToDomain(categoryEntitySaved);
    }
}
