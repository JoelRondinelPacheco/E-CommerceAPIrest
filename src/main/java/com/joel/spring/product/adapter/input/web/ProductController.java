package com.joel.spring.product.adapter.input.web;

import com.joel.spring.exceptions.NotFoundException;
import com.joel.spring.product.application.port.input.ProductPersistence;
import com.joel.spring.product.application.port.input.ProductSelector;
import com.joel.spring.product.application.port.input.ProductService;
import com.joel.spring.product.dto.ProductEditReqDTO;
import com.joel.spring.product.dto.ProductInfoDTO;
import com.joel.spring.product.dto.ProductPostReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductPersistence productPersistence;

    @Autowired
    private ProductService productService;

    @Autowired
    @Qualifier("productById")
    private ProductSelector<ProductInfoDTO, String> productById;

    @PostMapping
    public ResponseEntity<ProductInfoDTO> newProduct(@RequestBody ProductPostReqDTO product) {
        //TODO VALIDATE BODY

        return new ResponseEntity<>(this.productPersistence.save(product), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductInfoDTO> getById(@PathVariable String id) throws NotFoundException {
        return new ResponseEntity<>(this.productById.get(id), HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<?> updateProduct(@RequestBody ProductEditReqDTO product) {
        return null;
    }

    @GetMapping("/low-stock/{stock}")
    public List<ProductInfoDTO> lowStock(@PathVariable Long stock) {
        return this.productService.lowStockProducts(stock);
    }

    /*
    TODO change to disable
     @GetMapping("/low-stock/{stock}")
    public List<ProductInfoDTO> lackStock(@PathVariable Long stock) {
        return this.productService.getLowStock(stock);
    }
     */
}
