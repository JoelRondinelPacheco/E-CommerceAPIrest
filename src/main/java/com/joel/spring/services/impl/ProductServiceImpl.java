package com.joel.spring.services.impl;

import com.joel.spring.dtos.categories.CategoryParentInfoDTO;
import com.joel.spring.dtos.products.ProductEditReqDTO;
import com.joel.spring.dtos.products.ProductInfoDTO;
import com.joel.spring.dtos.products.ProductPostReqDTO;
import com.joel.spring.entities.CategoryEntity;
import com.joel.spring.product.adapter.out.persistence.ProductEntity;
import com.joel.spring.exceptions.NotFoundException;
import com.joel.spring.product.adapter.out.persistence.ProductRepository;
import com.joel.spring.services.CategoryService;
import com.joel.spring.services.ProductService;
import com.joel.spring.utils.CheckOptional;
import com.joel.spring.utils.categories.BuildCategoryDTOs;
import com.joel.spring.utils.products.BuildProductsDTOs;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired private ProductRepository productRepository;
    @Autowired private CategoryService categoryService;
    @Autowired private BuildCategoryDTOs categoryDTOs;
    @Autowired private CheckOptional checkOptional;
    @Autowired private BuildProductsDTOs productsDTOs;

    @Override
    public ProductEntity getById(String id) throws NotFoundException {
        //TODO verify id != null
        Optional<ProductEntity> optionalProduct = this.productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            ProductEntity productEntity = optionalProduct.get();
            return productEntity;
        }
        throw new NotFoundException("ProductEntity not found");
    }

    @Override
    @Transactional
    public ProductEntity save(ProductPostReqDTO dto) {
        List<CategoryEntity> categories = this.categoryService.getListCategoriesById(dto.getCategoriesId());
        return this.productRepository.save(
                ProductEntity.builder()
                        .name(dto.getName())
                        .brand(dto.getBrand())
                        .price(dto.getPrice())
                        .stock(dto.getStock())
                        .categories(categories)
                        .build());
    }

    @Override
    public ProductInfoDTO updateDTO(ProductEditReqDTO dto) throws NotFoundException {
        return this.productsDTOs.productInfoDTO(this.update(dto));

    }

    @Override
    public ProductInfoDTO getDTOById(String id) throws NotFoundException {
        Optional<ProductInfoDTO> optional = this.productRepository.getDTOById(id);
        ProductInfoDTO product = this.checkOptional.checkOptionalOk(optional);
        product.setCategories(this.categoryService.categoryParentInfoDTOListByProductId(id));
        return product;
    }

    @Override
    public ProductInfoDTO saveAndReturnDTO(ProductPostReqDTO dto) {
        return this.productsDTOs.productInfoDTO(this.save(dto));
    }

    @Override
    public String delete(String id) {
        this.productRepository.deleteById(id);
        return "ProductEntity deleted";
    }

    @Override
    public ProductEntity update(ProductEditReqDTO dto) throws NotFoundException {
        ProductEntity productEntity = this.getById(dto.getProductId());
        productEntity.setName(dto.getName());
        productEntity.setBrand(dto.getBrand());
        productEntity.setPrice(dto.getPrice());
        productEntity.setStock(dto.getStock());
        List<CategoryEntity> categories = new ArrayList<>();
        for (String id : dto.getCategoriesId()) {
            try {
                categories.add(this.categoryService.getCategoryById(id));
            } catch (NotFoundException e) {
                continue;
            }
        }
        productEntity.setCategories(categories);
        return this.productRepository.save(productEntity);
    }

    @Override
    public List<ProductEntity> getAll() {
        return this.productRepository.findAll();
    }

    @Override
    public int updateQuantity(String id, Double quantity){
    return this.productRepository.updateQuantity(id, quantity);
    }

    @Override
    public List<ProductInfoDTO> getLowStock (Long quantity) {
        return this.productRepository.getLowStock(quantity);
    }

    @Override
    public List<ProductInfoDTO> getAllDTO() {
        List<ProductInfoDTO> list = this.productRepository.getAllDTOs();
        for (ProductInfoDTO product : list) {
            List<String> categories = this.categoryService.categoriesIdByProduct(product.getId());
            List<CategoryParentInfoDTO> categoriesInfo = this.categoryService.categoryParentInfoDTOList(categories);
            product.setCategories(categoriesInfo);
        }
        return list;
    }

    @Override
    public List<ProductInfoDTO> getProductInfoBySaleId(String saleId) {
        return this.productRepository.getProductInfoBySaleId(saleId);
    }

}
