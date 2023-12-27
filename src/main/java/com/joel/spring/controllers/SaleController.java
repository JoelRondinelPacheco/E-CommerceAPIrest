package com.joel.spring.controllers;

import com.joel.spring.dtos.products.ProductInfoDTO;
import com.joel.spring.dtos.sales.*;
import com.joel.spring.entities.Product;
import com.joel.spring.entities.Sale;
import com.joel.spring.exceptions.NotFoundException;
import com.joel.spring.services.IProductService;
import com.joel.spring.services.ISaleService;
import com.joel.spring.services.impl.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController {
    @Autowired private ISaleService saleService;
    @Autowired private IProductService productService;

    @GetMapping
    public List<SaleInfoDTO> getAll(){
        return this.saleService.getAllDTO();
    }

    @PostMapping("/create")
    public ResponseEntity<SaleInfoDTO> save(@RequestBody SalePostReqDTO body) throws NotFoundException {
        return new ResponseEntity<>(this.saleService.saveDTO(body), HttpStatus.OK);
    }
    @GetMapping("/id/{saleId}")
    public ResponseEntity<SaleInfoDTO> getBiId(@PathVariable String saleId) throws NotFoundException {
        return new ResponseEntity<>(this.saleService.getByIdDTO(saleId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{saleId}")
    public ResponseEntity<String> delete(@PathVariable String saleId) {
        return new ResponseEntity<String>(this.saleService.delete(saleId), HttpStatus.OK);
    }

    @GetMapping("/products/{saleId}")
    public ResponseEntity<List<ProductInfoDTO>> getProducts(@PathVariable String saleId) {
        return new ResponseEntity<>(this.productService.getProductInfoBySaleId(saleId), HttpStatus.OK);
    }

    @GetMapping("/date/{saleDate}")
    public ResponseEntity<SaleInfoByDateDTO> getSaleInfoByDate(@PathVariable Date saleDate) {
        return new ResponseEntity<>(this.saleService.getSaleInfoByDate(saleDate), HttpStatus.OK);
    }

    @GetMapping("/max")
    public ResponseEntity<List<SaleMaxAmountDTO>> max(){
        return new ResponseEntity<>(this.saleService.getMaxAmountSale(), HttpStatus.OK);
    }

}
