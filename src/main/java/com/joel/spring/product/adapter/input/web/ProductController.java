package com.joel.spring.product.adapter.input.web;

import com.joel.spring.product.application.port.input.ProductPersistence;
import com.joel.spring.product.dto.ProductEditReqDTO;
import com.joel.spring.product.dto.ProductPostReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductPersistence productPersistence;

    @PostMapping
    public ResponseEntity<?> newProduct(@RequestBody ProductPostReqDTO product) {
        //TODO VALIDATE BODY

        return null;
    }

    @PatchMapping
    public ResponseEntity<?> updateProduct(@RequestBody ProductEditReqDTO product) {
        return null;
    }
}
