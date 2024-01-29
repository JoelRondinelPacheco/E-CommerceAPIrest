package com.joel.spring.controllers;

import com.joel.spring.dtos.cart.AddProductToCartDTO;
import com.joel.spring.dtos.cart.ProductInfoDTO;
import com.joel.spring.dtos.cartproduct.UpdateQuantityDTO;
import com.joel.spring.entities.CartProduct;
import com.joel.spring.exceptions.NotFoundException;
import com.joel.spring.services.CartProductService;
import com.joel.spring.services.CartService;
import com.joel.spring.services.JWTUtilityService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired private CartService cartService;
    @Autowired private CartProductService cartProductService;
    @Autowired private JWTUtilityService jwtService;


    @GetMapping("/products")
    public ResponseEntity<List<ProductInfoDTO>> getCartProducts(HttpServletRequest request) throws NotFoundException {
        String id = this.jwtService.getId(request.getHeader("Authorization").substring(7));
        return new ResponseEntity<>(this.cartService.getUserCard(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<CartProduct> addProduct(@RequestBody AddProductToCartDTO body, HttpServletRequest request) throws NotFoundException {
        String id = this.jwtService.getId(request.getHeader("Authorization").substring(7));
        CartProduct cartProduct = this.cartProductService.saveProduct(body, id);
        return new ResponseEntity<>(cartProduct, HttpStatus.OK);
    }

    @DeleteMapping("/remove/{cartProductId}")
    public ResponseEntity<String> removeFromCart(@PathVariable String cartProductId) throws NotFoundException {
        this.cartProductService.deleteProduct(cartProductId);
        return new ResponseEntity<>("Product deleted from cart", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<CartProduct> updateQuantity(@RequestBody UpdateQuantityDTO body) throws NotFoundException {
        CartProduct cartProduct = this.cartProductService.changeQuantity(body);
        return new ResponseEntity<>(cartProduct, HttpStatus.OK);
    }
}
