package com.joel.spring.services.impl;

import com.joel.spring.dtos.categories.CategoryParentInfoDTO;
import com.joel.spring.dtos.products.ProductEditReqDTO;
import com.joel.spring.dtos.products.ProductInfoDTO;
import com.joel.spring.dtos.products.ProductPostReqDTO;
import com.joel.spring.entities.Category;
import com.joel.spring.entities.Product;
import com.joel.spring.exceptions.NotFoundException;
import com.joel.spring.repositories.IProductRepository;
import com.joel.spring.services.ICategoryService;
import com.joel.spring.services.IProductService;
import com.joel.spring.utils.CheckOptional;
import com.joel.spring.utils.categories.BuildCategoryDTOs;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired private IProductRepository productRepository;
    @Autowired private ICategoryService categoryService;
    @Autowired private BuildCategoryDTOs categoryDTOs;
    @Autowired private CheckOptional checkOptional;

    @Override
    public Product getById(String id) throws NotFoundException {
        //TODO verify id != null
        Optional<Product> optionalProduct = this.productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            return product;
        }
        throw new NotFoundException("Product not found");
    }

    @Override
    @Transactional
    public Product save(ProductPostReqDTO dto) {
        List<Category> categories = this.categoryService.getListCategoriesById(dto.getCategoriesId());
        return this.productRepository.save(
                Product.builder()
                        .name(dto.getName())
                        .brand(dto.getBrand())
                        .price(dto.getPrice())
                        .stock(dto.getStock())
                        .categories(categories)
                        .build());
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
        return this.productInfoDTO(this.save(dto));
    }

    @Override
    public String delete(String id) {
        this.productRepository.deleteById(id);
        return "Product deleted";
    }

    @Override
    public Product update(ProductEditReqDTO dto) throws NotFoundException {
        Product product = this.getById(dto.getProductId());
        product.setName(dto.getName());
        product.setBrand(dto.getBrand());
        product.setPrice(dto.getPrice());
        product.setStock(dto.getStock());
        return this.productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    @Override
    public int updateQuantity(String id, Double quantity){
    return this.productRepository.updateQuantity(id, quantity);
    }

    @Override
    public List<ProductInfoDTO> getLackStock (Long quantity) {
        return this.productRepository.getLackStock(quantity);
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

    private ProductInfoDTO productInfoDTO(Product product) {
        List<CategoryParentInfoDTO> categories = this.categoryDTOs.categoryParentInfoDTOList(product.getCategories());
        return ProductInfoDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .brand(product.getBrand())
                .price(product.getPrice())
                .stock(product.getStock())
                .categories(categories)
                .build();
    }

}
