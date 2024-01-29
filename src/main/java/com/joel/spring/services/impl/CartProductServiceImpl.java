package com.joel.spring.services.impl;

import com.joel.spring.dtos.cart.AddProductToCartDTO;
import com.joel.spring.dtos.cartproduct.UpdateQuantityDTO;
import com.joel.spring.entities.Cart;
import com.joel.spring.entities.CartProduct;
import com.joel.spring.entities.Product;
import com.joel.spring.exceptions.NotFoundException;
import com.joel.spring.repositories.CartProductRepository;
import com.joel.spring.services.CartProductService;
import com.joel.spring.services.CartService;
import com.joel.spring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartProductServiceImpl implements CartProductService {

    @Autowired private CartProductRepository cartProductRepository;
    @Autowired private CartService cartService;
    @Autowired private ProductService productService;

    @Override
    public CartProduct saveProduct(AddProductToCartDTO dto, String id) throws NotFoundException {
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
    public void deleteProduct(String cartProductId) throws NotFoundException {
        if (this.cartProductRepository.existsById(cartProductId)) {
            this.cartProductRepository.deleteById(cartProductId);
            return;
        }
        throw new NotFoundException("Cart product not found");
    }

    @Override
    public CartProduct changeQuantity(UpdateQuantityDTO dto) throws NotFoundException{
        CartProduct cartProduct = this.getById(dto.getId());
        cartProduct.setQuantity(dto.getQuantity());
        return cartProductRepository.save(cartProduct);
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
