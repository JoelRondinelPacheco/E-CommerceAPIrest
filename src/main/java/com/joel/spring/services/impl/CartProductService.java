package com.joel.spring.services.impl;

import com.joel.spring.dtos.cart.AddProductToCartDTO;
import com.joel.spring.entities.Cart;
import com.joel.spring.entities.CartProduct;
import com.joel.spring.entities.Product;
import com.joel.spring.exceptions.NotFoundException;
import com.joel.spring.repositories.ICartProductRepository;
import com.joel.spring.repositories.ICartRepository;
import com.joel.spring.services.ICartProductService;
import com.joel.spring.services.ICartService;
import com.joel.spring.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CartProductService implements ICartProductService {

    @Autowired private ICartProductRepository cartProductRepository;
    @Autowired private ICartService cartService;
    @Autowired private IProductService productService;

    @Override
    public CartProduct save(AddProductToCartDTO dto, String id) throws NotFoundException {
        // fijarse si ya lo tiene agregado
            Cart cart = this.cartService.findByUserId(id);
            try {
                CartProduct cartProduct = this.getById(cart.getId());
                cartProduct.setQuantity(dto.getQuantity());
                return this.cartProductRepository.save(cartProduct);
            } catch (NotFoundException e) {
                Product product = this.productService.getById(dto.getProductId());
                CartProduct cartProduct = CartProduct.builder()
                        .product(product)
                        .quantity(dto.getQuantity())
                        .cart(cart)
                        .build();
                return this.cartProductRepository.save(cartProduct);
            }
    }

    @Override
    public CartProduct getById(String id) throws NotFoundException {
        Optional<CartProduct> optional = this.cartProductRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        throw new NotFoundException("CartProduct not found");
    }


}
