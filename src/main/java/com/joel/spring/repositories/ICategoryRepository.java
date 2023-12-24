package com.joel.spring.repositories;

import com.joel.spring.dtos.categories.CategoryInfoDTO;
import com.joel.spring.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ICategoryRepository extends JpaRepository<Category, String> {
    @Query("SELECT new com.joel.spring.dtos.categories.CategoryDTO(c.id, c.name. c.categoryOrder) FROM Category c WHERE c.parent.id = :parentId")
    List<CategoryInfoDTO> categoryInfoDTOByParentId(@Param("parentId") String parentId);

    @Query("SELECT new com.joel.spring.dtos.categories.CategoryInfoDTO(c.id, c.name. c.categoryOrder) FROM Category c WHERE c.id = :id")
    Optional<CategoryInfoDTO> categoryInfoDTOById(@Param("id") String id);

}
