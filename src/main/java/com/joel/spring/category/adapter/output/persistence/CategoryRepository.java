package com.joel.spring.category.adapter.output.persistence;

import com.joel.spring.category.application.dto.CategoryInfoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, String> {
    @Query("SELECT new com.joel.spring.category.application.dto.CategoryInfoDTO(cat.id, cat.name, cat.displayOrder) FROM CategoryEntity cat WHERE cat.parent.id = :parentId")
    List<CategoryInfoDTO> categoryInfoDTOByParentId(@Param("parentId") String parentId);

    @Query("SELECT new com.joel.spring.category.application.dto.CategoryInfoDTO(c.id, c.name, c.displayOrder) FROM CategoryEntity c WHERE c.id = :id")
    Optional<CategoryInfoDTO> categoryInfoDTOById(@Param("id") String id);

    @Query("SELECT c.id FROM CategoryEntity c JOIN c.products p WHERE p.id = :productId")
    List<String> getCategoriesIdByProductId(@Param("productId") String productId);
}
