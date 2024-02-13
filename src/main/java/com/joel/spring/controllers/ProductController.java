package com.joel.spring.controllers;

import com.joel.spring.product.dto.ProductEditReqDTO;
import com.joel.spring.product.dto.ProductInfoDTO;
import com.joel.spring.product.dto.ProductPostReqDTO;
import com.joel.spring.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<ProductInfoDTO> create(@RequestBody ProductPostReqDTO body) {
        return new ResponseEntity<>( this.productService.saveAndReturnDTO(body), HttpStatus.CREATED);
    }

    @GetMapping
    public List<ProductInfoDTO> getAll() {
        return this.productService.getAllDTO();
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductInfoDTO> getById(@PathVariable String productId) throws NotFoundException {
        return new ResponseEntity<>(this.productService.getDTOById(productId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<String> delete(@PathVariable String productId) {
        this.productService.delete(productId);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }


    @PutMapping("/edit")
    public ResponseEntity<ProductInfoDTO> edit(@RequestBody ProductEditReqDTO body) throws NotFoundException {
        return new ResponseEntity<>(this.productService.updateDTO(body), HttpStatus.OK);
    }

    @GetMapping("/low-stock/{stock}")
    public List<ProductInfoDTO> lackStock(@PathVariable Long stock) {
        return this.productService.getLowStock(stock);
    }
}
