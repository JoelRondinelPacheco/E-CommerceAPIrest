package com.joel.spring.services.impl;

import com.joel.spring.dtos.cart.AddProductToCartDTO;
import com.joel.spring.dtos.cartproduct.UpdateQuantityDTO;
import com.joel.spring.cart.adapter.out.persistence.entity.CartEntity;
import com.joel.spring.cart.adapter.out.persistence.cartproduct.CartProductEntity;
import com.joel.spring.product.adapter.out.persistence.ProductEntity;
import com.joel.spring.exceptions.NotFoundException;
import com.joel.spring.cart.adapter.out.persistence.repository.CartProductRepository;
import com.joel.spring.services.CartProductService;
import com.joel.spring.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartProductServiceImpl implements CartProductService {

    @Autowired private CartProductRepository cartProductRepository;
    @Autowired private CartService cartService;
    @Autowired private ProductService productService;

    @Override
    public CartProductEntity saveProduct(AddProductToCartDTO dto, String id) throws NotFoundException {
        CartEntity cartEntity = this.cartService.findByUserId(id);
        try {
            CartProductEntity cartProductEntity = this.getById(cartEntity.getId());
            cartProductEntity.setQuantity(dto.getQuantity());
            return this.cartProductRepository.save(cartProductEntity);
        } catch (NotFoundException e) {
            ProductEntity productEntity = this.productService.getById(dto.getProductId());
            CartProductEntity cartProductEntity = CartProductEntity.builder()
                    .product(productEntity)
                    .quantity(dto.getQuantity())
                    .cart(cartEntity)
                    .build();
            return this.cartProductRepository.save(cartProductEntity);
        }
    }

    @Override
    public void deleteProduct(String cartProductId) throws NotFoundException {
        if (this.cartProductRepository.existsById(cartProductId)) {
            this.cartProductRepository.deleteById(cartProductId);
            return;
        }
        throw new NotFoundException("CartEntity productEntity not found");
    }

    @Override
    public CartProductEntity changeQuantity(UpdateQuantityDTO dto) throws NotFoundException{
        CartProductEntity cartProductEntity = this.getById(dto.getId());
        cartProductEntity.setQuantity(dto.getQuantity());
        return cartProductRepository.save(cartProductEntity);
    }

    @Override
    public CartProductEntity getById(String id) throws NotFoundException {
        Optional<CartProductEntity> optional = this.cartProductRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new NotFoundException("CartProductEntity not found");
    }


}
