package com.joel.spring.category.adapter.output.persistence.mapper;

import com.joel.spring.category.adapter.output.persistence.entity.SubCategoryEntity;
import com.joel.spring.category.domain.SubCategory;
import com.joel.spring.utils.Mapper;

import java.util.List;

public interface SubCategoryMapper extends Mapper<SubCategoryEntity, SubCategory> {
    List<SubCategory> entityToDomainList(List<SubCategoryEntity> subCategoryEntities);
}
