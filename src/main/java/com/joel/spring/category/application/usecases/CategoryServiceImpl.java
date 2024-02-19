package com.joel.spring.category.application.usecases;

import com.joel.spring.category.application.port.outpout.CategorySelectorPort;
import com.joel.spring.category.domain.Category;
import com.joel.spring.category.application.dto.CategoryInfoDTO;
import com.joel.spring.category.application.dto.CategoryParentInfoDTO;
import com.joel.spring.exceptions.NotFoundException;
import com.joel.spring.category.application.port.input.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategorySelectorPort categorySelectorPort;

    @Override
    public List<Category> categoriesById(List<String> categoriesId) {
        return this.categorySelectorPort.getCategoriesByIds(categoriesId);
    }


    @Override
    public List<CategoryInfoDTO> categoryInfoDTOList(String parentId) {
        return null;
    }

    @Override
    public CategoryParentInfoDTO categoryParentInfoDTO(String id) {
        return null;
    }

    @Override
    public List<CategoryParentInfoDTO> categoryParentInfoDTOList(List<String> categories) {
        return null;
    }

    @Override
    public List<CategoryParentInfoDTO> categoryParentInfoDTOListByProductId(String id) {
        return null;
    }

    @Override
    public List<String> categoriesIdByProduct(String productId) {
    return null;
    }
    /*
        public List<CategoryEntity> getListCategoriesById(List<String> categoriesId) {
        List<CategoryEntity> categories = new ArrayList<>();
        for (String id : categoriesId) {
            try {
                categories.add(this.getCategoryById(id));
            } catch (NotFoundException e) {
                continue;
            }
        }
        return categories;
    }

    public CategoryEntity getCategoryById(String id) throws NotFoundException {
        Optional<CategoryEntity> optional = this.categoryRepository.findById(id);
       return this.checkOptional.checkOptionalOk(optional);
    }

    public List<CategoryInfoDTO> categoryInfoDTOList(String parentId) {
        return this.categoryRepository.categoryInfoDTOByParentId(parentId);
    }
    public CategoryParentInfoDTO categoryParentInfoDTO(String id) throws NotFoundException {
        Optional<CategoryInfoDTO> optional = this.categoryRepository.categoryInfoDTOById(id);
        //Info de parent
        CategoryInfoDTO parentInfo =  this.checkOptional.checkOptionalOk(optional);
        List<CategoryInfoDTO> children = this.categoryInfoDTOList(id);
        return CategoryParentInfoDTO.builder()
                .id(parentInfo.getId())
                .name(parentInfo.getName())
                .categoryOrder(parentInfo.getCategoryOrder())
                .children(children)
                .build();
    }

    public List<CategoryParentInfoDTO> categoryParentInfoDTOList(List<String> categories) {
        List<CategoryParentInfoDTO> categoriesDTO = new ArrayList<>();
        for (String id : categories) {
            try {
                categoriesDTO.add(this.categoryParentInfoDTO(id));
            } catch (NotFoundException e) {
                continue;
            }
        }
        return categoriesDTO;
    }

    public List<CategoryParentInfoDTO> categoryParentInfoDTOListByProductId(String id) {
        List<String> categoriesId = this.categoriesIdByProduct(id);
        return this.categoryParentInfoDTOList(categoriesId);
    }

    public List<String> categoriesIdByProduct(String productId) {
        return this.categoryRepository.getCategoriesIdByProductId(productId);
    }

     */
}
