package com.joel.spring.controllers;

import com.joel.spring.dtos.cart.AddProductToCartDTO;
import com.joel.spring.entities.CartProduct;
import com.joel.spring.exceptions.NotFoundException;
import com.joel.spring.services.ICartProductService;
import com.joel.spring.services.ICartService;
import com.joel.spring.services.IJWTUtilityService;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jwt.JWTClaimsSet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.text.ParseException;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired private ICartService cartService;
    @Autowired private ICartProductService cartProductService;
    @Autowired private IJWTUtilityService jwtService;

    @PostMapping("/add")
    public ResponseEntity<CartProduct> addProduct(@RequestBody AddProductToCartDTO body, HttpServletRequest request) throws NotFoundException {
        String token = request.getHeader("Authorization").substring(7);
            String id = this.jwtService.getId(token);
            CartProduct cartProduct = this.cartProductService.saveProduct(body, id);
            return new ResponseEntity(cartProduct, HttpStatus.OK);


    }
}
