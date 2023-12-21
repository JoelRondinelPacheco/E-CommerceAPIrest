package com.joel.spring.controllers;

import com.joel.spring.dtos.sales.*;
import com.joel.spring.entities.Product;
import com.joel.spring.entities.Sale;
import com.joel.spring.exceptions.NotFoundException;
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
    private SaleService saleService;

    @PostMapping("/create")
    public ResponseEntity<Sale> save(@RequestBody SalePostReqDTO body) throws NotFoundException {
        return new ResponseEntity<Sale>(this.saleService.save(body), HttpStatus.OK);
    }

    @GetMapping
    public List<Sale> getAll(){
        return this.saleService.getAll();
    }

    @GetMapping("/id/{sale_id}")
    public ResponseEntity<Sale> getBiId(@PathVariable Long sale_id) throws NotFoundException {
        return new ResponseEntity<Sale>(this.saleService.getById(sale_id), HttpStatus.FOUND);
    }

    @DeleteMapping("/delete/{sale_id}")
    public ResponseEntity<String> delete(@PathVariable Long sale_id) {
        return new ResponseEntity<String>(this.saleService.delete(sale_id), HttpStatus.OK);
    }

    @PutMapping("/edit/{sale_id}")
    public ResponseEntity<Sale> update(@RequestBody SaleEditReqDTO body, @PathVariable Long sale_id) throws NotFoundException {
        return new ResponseEntity<Sale>(this.saleService.update(body), HttpStatus.OK);
    }

    @GetMapping("/products/{sale_id}")
    public ResponseEntity<List<Product>> getProducts(@PathVariable Long sale_id) {
        return new ResponseEntity<List<Product>>(this.saleService.getProducts(sale_id), HttpStatus.FOUND);
    }

    @GetMapping("/{sale_date}")
    public ResponseEntity<SaleInfoByDateDTO> getSaleInfoByDate(@PathVariable Date sale_date) {
        return new ResponseEntity<>(this.saleService.getSaleInfoByDate(sale_date), HttpStatus.OK);
    }

    @GetMapping("/max")
    public ResponseEntity<List<SaleMaxAmountDTO>> max(){
        return new ResponseEntity<>(this.saleService.getMaxAmountSale(), HttpStatus.OK);
    }

}
