package com.joel.spring.category.adapter.output.persistence;

import com.joel.spring.category.adapter.output.persistence.entity.CategoryEntity;
import com.joel.spring.category.application.port.outpout.CategorySelectorPort;
import com.joel.spring.category.domain.Category;
import com.joel.spring.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@Qualifier("categoryById")
public class CategorySelectorPersistenceAdapter implements CategorySelectorPort {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    @Qualifier("categoryMapper")
    private Mapper<CategoryEntity, Category> mapper;

    @Override
    public Category getById(String id) {
        Optional<CategoryEntity> optional = this.categoryRepository.findById(id);
        //Category cat = this.categoryRepository.findById(id).map(this.mapper::entityToDomain).orElseThrow();
        if(optional.isPresent()){
            return this.mapper.entityToDomain(optional.get());
        }
        //TODO CUSTOM EX
        throw new RuntimeException("TODO CUSTOM EX");
    }

    @Override
    public List<Category> getCategoriesByIds(List<String> ids) {
        return this.categoryRepository.findAllById(ids).stream().map(this.mapper::entityToDomain).toList();
    }
}
