package com.joel.spring.category.adapter.output.persistence.mapper;

import com.joel.spring.category.adapter.output.persistence.entity.SubCategoryEntity;
import com.joel.spring.category.domain.SubCategory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Qualifier("subCategoryMapper")
public class SubCategoryMapperImpl implements SubCategoryMapper {

    @Override
    public SubCategory entityToDomain(SubCategoryEntity subCategoryEntity) {
        SubCategory subCategory = SubCategory.builder()
                .id(subCategoryEntity.getId())
                .name(subCategoryEntity.getName())
                .build();
        return subCategory;
    }

    @Override
    public SubCategoryEntity domainToEntity(SubCategory subCategory) {
        return SubCategoryEntity.builder()
                .name(subCategory.getName())
                .build();
    }

    @Override
    public List<SubCategory> entityToDomainList(List<SubCategoryEntity> subCategoryEntities) {
        List<SubCategory> subCategories = new ArrayList<>();

        for (SubCategoryEntity s : subCategoryEntities) {
            subCategories.add(this.entityToDomain(s));
        }

        return subCategories;
    }

    @Override
    public List<SubCategoryEntity> domaintToEntityList(List<SubCategory> subCategories) {
        List<SubCategoryEntity> subCategoryEntities = new ArrayList<>();

        for (SubCategory s : subCategories) {
            subCategoryEntities.add(this.domainToEntity(s));
        }

        return subCategoryEntities;
    }
}
