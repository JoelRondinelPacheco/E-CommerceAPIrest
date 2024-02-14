package com.joel.spring.cart.adapter.input.web;

import com.joel.spring.dtos.cart.AddProductToCartDTO;
import com.joel.spring.dtos.cart.ProductCartInfoDTO;
import com.joel.spring.dtos.cartproduct.UpdateQuantityDTO;
import com.joel.spring.cart.adapter.out.persistence.cartproduct.CartProductEntity;
import com.joel.spring.exceptions.NotFoundException;
import com.joel.spring.services.CartProductService;
import com.joel.spring.services.CartService;
import com.joel.spring.user.application.usecases.JWTUtilityService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartEntity")
public class CartController {

    @Autowired private CartService cartService;
    @Autowired private CartProductService cartProductService;
    @Autowired private JWTUtilityService jwtService;


    @GetMapping("/products")
    public ResponseEntity<List<ProductCartInfoDTO>> getCartProducts(HttpServletRequest request) throws NotFoundException {
        String id = this.jwtService.getId(request.getHeader("Authorization").substring(7));
        return new ResponseEntity<>(this.cartService.getUserCard(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<CartProductEntity> addProduct(@RequestBody AddProductToCartDTO body, HttpServletRequest request) throws NotFoundException {
        String id = this.jwtService.getId(request.getHeader("Authorization").substring(7));
        CartProductEntity cartProductEntity = this.cartProductService.saveProduct(body, id);
        return new ResponseEntity<>(cartProductEntity, HttpStatus.OK);
    }

    @DeleteMapping("/remove/{cartProductId}")
    public ResponseEntity<String> removeFromCart(@PathVariable String cartProductId) throws NotFoundException {
        this.cartProductService.deleteProduct(cartProductId);
        return new ResponseEntity<>("ProductEntity deleted from cartEntity", HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<CartProductEntity> updateQuantity(@RequestBody UpdateQuantityDTO body) throws NotFoundException {
        CartProductEntity cartProductEntity = this.cartProductService.changeQuantity(body);
        return new ResponseEntity<>(cartProductEntity, HttpStatus.OK);
    }
}
