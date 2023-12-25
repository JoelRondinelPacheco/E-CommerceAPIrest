package com.joel.spring.services.impl;

import com.joel.spring.dtos.sales.*;
import com.joel.spring.entities.UserEntity;
import com.joel.spring.entities.Product;
import com.joel.spring.entities.Sale;
import com.joel.spring.exceptions.NotFoundException;
import com.joel.spring.repositories.ISaleRepository;
import com.joel.spring.services.ISaleService;
import com.joel.spring.utils.sales.BuildSalesDTOs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

// TODO CAMBIAR STOCK DE PRODUCTOS AL REALIZAR UNA VENTA, Y FIJARSE QUE EL PRODUCTO ES TE DISPONIBLE
@Service
public class SaleService implements ISaleService {
    @Autowired private ISaleRepository saleRepository;
    @Autowired private UserService userService;
    @Autowired private ProductService productService;
    @Autowired private BuildSalesDTOs salesDTOs;

    @Override
    public Sale getById(String id) throws NotFoundException {
        Optional<Sale> saleOptional = this.saleRepository.findById(id);
        if (saleOptional.isPresent()) {
            return saleOptional.get();
        }
        throw new NotFoundException("Sale not found");
    }

    @Override
    public Sale save(SalePostReqDTO body) throws NotFoundException {
        UserEntity userEntity = this.userService.getById(body.getClientId());
        List<Product> products = new ArrayList<>();
        for (String productId : body.getProducts() ) {
            Product product = this.productService.getById(productId);
            products.add(product);
            this.productService.updateQuantity( product.getId(), 1D);
        }

        Double totalPrice = 0D;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }

        return this.saleRepository.save(new Sale(userEntity, products, totalPrice));
    }

    @Override
    public String delete(String id) {
        this.saleRepository.deleteById(id);
        return "Product deleted";
    }

    @Override
    public Sale update(SaleEditReqDTO body) throws NotFoundException {
        Optional<Sale> saleOptional = this.saleRepository.findById(body.getSaleId());
        if (saleOptional.isPresent()) {
            Sale sale = saleOptional.get();
            UserEntity userEntity = this.userService.getById(body.getClientId());
            sale.setClient(userEntity);
            return this.saleRepository.save(sale);

        }
        throw new NotFoundException("Sale not found");

    }

    @Override
    public List<Sale> getAll() {
        return this.saleRepository.findAll();
    }

    @Override
    public List<Product> getProducts(String id) {
        return this.saleRepository.findProductsBySaleId(id);
    }

    @Override
    public SaleInfoByDateDTO getSaleInfoByDate(Date date) {
        Double total_amount = this.saleRepository.totalAmountByDate(date);
        int total_sales = this.saleRepository.countSalesByDate(date);
        return new SaleInfoByDateDTO(total_amount, total_sales);
    }

    @Override
    public List<SaleMaxAmountDTO> getMaxAmountSale() {
        List<SaleMaxAmountDTO> max = this.saleRepository.saleMaxAmount();
        return this.saleRepository.saleMaxAmount();
    }

    @Override
    public SaleInfoDTO saveDTO(SalePostReqDTO body) throws NotFoundException {
        Sale s = this.save(body);
        return this.salesDTOs.saleInfoDTO(s);

    }
}
