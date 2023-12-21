package com.joel.spring.services.impl;

import com.joel.spring.dtos.products.ProductEditReqDTO;
import com.joel.spring.dtos.products.ProductPostReqDTO;
import com.joel.spring.entities.Product;
import com.joel.spring.exceptions.NotFoundException;
import com.joel.spring.repositories.IProductRepository;
import com.joel.spring.services.IProductService;
import jakarta.transaction.Transactional;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;


    @Override
    public Product getById(Long id) throws NotFoundException {
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
        Product product = this.productRepository.save(new Product(dto.getName(), dto.getBrand(), dto.getPrice(), dto.getQuantity_available()));
        return product;
    }

    @Override
    public String delete(Long id) {
        this.productRepository.deleteById(id);
        return "Product deleted";
    }

    @Override
    public Product update(ProductEditReqDTO dto) throws NotFoundException {
        Product product = this.getById(dto.getProduct_id());
        product.setName(dto.getName());
        product.setBrand(dto.getBrand());
        product.setPrice(dto.getPrice());
        product.setQuantity_available(dto.getQuantity_available());
        return this.productRepository.save(product);
    }

    @Override
    public List<Product> getAll() {
        return this.productRepository.findAll();
    }

    @Override
    public int updateQuantity(Long id, Double quantity){
    int i = this.productRepository.updateQuantity(id, quantity);
    return i;
    }

    @Override
    public List<Product> getLackStock (Long quantity) {
        return this.productRepository.getLackStock(quantity);
    }
}
