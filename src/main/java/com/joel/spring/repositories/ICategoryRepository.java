package com.joel.spring.repositories;

import com.joel.spring.dtos.categories.CategoryInfoDTO;
import com.joel.spring.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, String> {
    @Query("SELECT new com.joel.spring.dtos.categories.CategoryInfoDTO(cat.id, cat.name, cat.categoryOrder) FROM Category cat WHERE cat.parent.id = :parentId")
    List<CategoryInfoDTO> categoryInfoDTOByParentId(@Param("parentId") String parentId);

    @Query("SELECT new com.joel.spring.dtos.categories.CategoryInfoDTO(c.id, c.name, c.categoryOrder) FROM Category c WHERE c.id = :id")
    Optional<CategoryInfoDTO> categoryInfoDTOById(@Param("id") String id);

    @Query("SELECT c.id FROM Category c JOIN c.products p WHERE p.id = :productId")
    List<String> getCategoriesIdByProductId(@Param("productId") String productId);
}
