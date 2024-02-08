package com.joel.spring.sales.application.usecases;

import com.joel.spring.dtos.sales.*;
import com.joel.spring.user.infrastructure.output.persistence.UserEntity;
import com.joel.spring.entities.Product;
import com.joel.spring.sales.adapter.output.persistence.SaleEntity;
import com.joel.spring.exceptions.NotFoundException;
import com.joel.spring.sales.adapter.output.persistence.JpaMySQLSaleRepository;
import com.joel.spring.services.ProductService;
import com.joel.spring.sales.application.port.input.SaleService;
import com.joel.spring.user.application.port.input.UserService;
import com.joel.spring.utils.CheckOptional;
import com.joel.spring.utils.sales.BuildSalesDTOs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

// TODO CAMBIAR STOCK DE PRODUCTOS AL REALIZAR UNA VENTA, Y FIJARSE QUE EL PRODUCTO ES TE DISPONIBLE
@Service
public class SaleServiceImpl implements SaleService {
    @Autowired private JpaMySQLSaleRepository jpaMySQLSaleRepository;
    @Autowired private UserService userService;
    @Autowired private ProductService productService;
    @Autowired private BuildSalesDTOs salesDTOs;
    @Autowired private CheckOptional checkOptional;

    @Override
    public SaleEntity getById(String id) throws NotFoundException {
        Optional<SaleEntity> saleOptional = this.jpaMySQLSaleRepository.findById(id);
        if (saleOptional.isPresent()) {
            return saleOptional.get();
        }
        throw new NotFoundException("SaleEntity not found");
    }

    @Override
    public SaleEntity save(SalePostReqDTO body) throws NotFoundException {
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

        return this.jpaMySQLSaleRepository.save(new SaleEntity(userEntity, products, totalPrice));
    }

    @Override
    public String delete(String id) {
        this.jpaMySQLSaleRepository.deleteById(id);
        return "SaleEntity deleted";
    }

    @Override
    public SaleEntity update(SaleEditReqDTO body) throws NotFoundException {
        Optional<SaleEntity> saleOptional = this.jpaMySQLSaleRepository.findById(body.getSaleId());
        if (saleOptional.isPresent()) {
            SaleEntity saleEntity = saleOptional.get();
            UserEntity userEntity = this.userService.getById(body.getClientId());
            saleEntity.setClient(userEntity);
            return this.jpaMySQLSaleRepository.save(saleEntity);

        }
        throw new NotFoundException("SaleEntity not found");

    }

    @Override
    public List<SaleEntity> getAll() {
        return this.jpaMySQLSaleRepository.findAll();
    }

    @Override
    public List<Product> getProducts(String id) {
        return this.jpaMySQLSaleRepository.findProductsBySaleId(id);
    }

    @Override
    public SaleInfoByDateDTO getSaleInfoByDate(Date date) {
        Double total_amount = this.jpaMySQLSaleRepository.totalAmountByDate(date);
        int total_sales = this.jpaMySQLSaleRepository.countSalesByDate(date);
        return new SaleInfoByDateDTO(total_amount, total_sales);
    }

    @Override
    public List<SaleMaxAmountDTO> getMaxAmountSale() {
        List<SaleMaxAmountDTO> max = this.jpaMySQLSaleRepository.saleMaxAmount();
        return this.jpaMySQLSaleRepository.saleMaxAmount();
    }

    @Override
    public SaleInfoDTO saveDTO(SalePostReqDTO body) throws NotFoundException {
        SaleEntity s = this.save(body);
        return this.salesDTOs.saleInfoDTO(s);

    }

    @Override
    public List<SaleInfoDTO> getAllDTO() {
        List<SaleInfoDTO> sales = this.jpaMySQLSaleRepository.getAllSalesDTOs();
        for (SaleInfoDTO s : sales) {
            s.setProducts(this.productService.getProductInfoBySaleId(s.getSaleId()));
        }
        return sales;
    }

    @Override
    public SaleInfoDTO getByIdDTO(String saleId) throws NotFoundException{
        Optional<SaleInfoDTO> optional = this.jpaMySQLSaleRepository.getSaleByIdDTO(saleId);
        return this.checkOptional.checkOptionalOk(optional, "SaleEntity");
    }
}
