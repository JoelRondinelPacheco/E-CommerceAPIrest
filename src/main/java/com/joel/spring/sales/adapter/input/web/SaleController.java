package com.joel.spring.sales.adapter.input.web;

import com.joel.spring.sales.application.port.input.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/saleEntities")
public class SaleController {
    @Autowired private SaleService saleService;
/*
    @GetMapping
    public List<SaleInfoDTO> getAll(){
        return this.saleService.getAllDTO();
    }

    @PostMapping("/create")
    public ResponseEntity<SaleInfoDTO> save(@RequestBody SalePostReqDTO body) throws NotFoundException {
        return new ResponseEntity<>(this.saleService.saveDTO(body), HttpStatus.OK);
    }
    @GetMapping("/id/{saleId}")
    public ResponseEntity<SaleInfoDTO> getById(@PathVariable String saleId) throws NotFoundException {
        return new ResponseEntity<>(this.saleService.getByIdDTO(saleId), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{saleId}")
    public ResponseEntity<String> delete(@PathVariable String saleId) {
        return new ResponseEntity<String>(this.saleService.delete(saleId), HttpStatus.OK);
    }

    //TODO, MOVE TO PRODUCTS CONTROLLER ???
    @GetMapping("/products/{saleId}")
    public ResponseEntity<List<ProductCartInfoDTO>> getProducts(@PathVariable String saleId) {
        return new ResponseEntity<>(this.productService.getProductInfoBySaleId(saleId), HttpStatus.OK);
    }

    @GetMapping("/date/{saleDate}")
    public ResponseEntity<SaleInfoByDateDTO> getSaleInfoByDate(@PathVariable Date saleDate) {
        return new ResponseEntity<>(this.saleService.getSaleInfoByDate(saleDate), HttpStatus.OK);
    }

    @GetMapping("/max")
    public ResponseEntity<List<SaleMaxAmountDTO>> max(){
        return new ResponseEntity<>(this.saleService.getMaxAmountSale(), HttpStatus.OK);
    }*/

}
