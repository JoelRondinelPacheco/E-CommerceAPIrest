package com.joel.spring.controllers;

import com.joel.spring.dtos.sales.*;
import com.joel.spring.entities.Product;
import com.joel.spring.entities.Sale;
import com.joel.spring.exceptions.NotFoundException;
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
    @Autowired
    private ISaleService saleService;

    @PostMapping("/create")
    public ResponseEntity<SaleInfoDTO> save(@RequestBody SalePostReqDTO body) throws NotFoundException {
        return new ResponseEntity<>(this.saleService.saveDTO(body), HttpStatus.OK);
    }

    @GetMapping
    public List<Sale> getAll(){
        return this.saleService.getAll();
    }

    @GetMapping("/id/{saleId}")
    public ResponseEntity<Sale> getBiId(@PathVariable String saleId) throws NotFoundException {
        return new ResponseEntity<Sale>(this.saleService.getById(saleId), HttpStatus.FOUND);
    }

    @DeleteMapping("/delete/{saleId}")
    public ResponseEntity<String> delete(@PathVariable String saleId) {
        return new ResponseEntity<String>(this.saleService.delete(saleId), HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Sale> update(@RequestBody SaleEditReqDTO body) throws NotFoundException {
        return new ResponseEntity<Sale>(this.saleService.update(body), HttpStatus.OK);
    }

    @GetMapping("/products/{saleId}")
    public ResponseEntity<List<Product>> getProducts(@PathVariable String saleId) {
        return new ResponseEntity<List<Product>>(this.saleService.getProducts(saleId), HttpStatus.FOUND);
    }

    @GetMapping("/{saleDate}")
    public ResponseEntity<SaleInfoByDateDTO> getSaleInfoByDate(@PathVariable Date saleDate) {
        return new ResponseEntity<>(this.saleService.getSaleInfoByDate(saleDate), HttpStatus.OK);
    }

    @GetMapping("/max")
    public ResponseEntity<List<SaleMaxAmountDTO>> max(){
        return new ResponseEntity<>(this.saleService.getMaxAmountSale(), HttpStatus.OK);
    }

}
