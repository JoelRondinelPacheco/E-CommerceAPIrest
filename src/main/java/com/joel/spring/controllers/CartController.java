package com.joel.spring.controllers;

import com.joel.spring.dtos.cart.AddProductToCartDTO;
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
    @Autowired private IJWTUtilityService jwtService;

    @PostMapping("/add")
    public ResponseEntity addProduct(@RequestBody AddProductToCartDTO body, HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            return new ResponseEntity("Invalid credentials" , HttpStatus.UNAUTHORIZED);
        }
        String token = header.substring(7);
        try {
            JWTClaimsSet claims = this.jwtService.parseJWT(token);
            String id = claims.getSubject();
            return new ResponseEntity(id, HttpStatus.OK);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        } catch (JOSEException e) {
            throw new RuntimeException(e);
        }

    }
}
