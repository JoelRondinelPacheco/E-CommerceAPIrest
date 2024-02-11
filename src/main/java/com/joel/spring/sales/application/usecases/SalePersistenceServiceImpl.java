package com.joel.spring.sales.application.usecases;

import com.joel.spring.dtos.sales.SalePostReqDTO;
import com.joel.spring.product.adapter.out.persistence.ProductEntity;
import com.joel.spring.exceptions.NotFoundException;
import com.joel.spring.product.application.port.input.ProductSelector;
import com.joel.spring.product.application.port.output.ProductsByUser;
import com.joel.spring.product.domain.Product;
import com.joel.spring.sales.adapter.output.persistence.SaleEntity;
import com.joel.spring.sales.application.port.input.SalePersistenceService;
import com.joel.spring.sales.domain.Sale;
import com.joel.spring.user.application.port.input.UserSelector;
import com.joel.spring.user.domain.User;
import com.joel.spring.user.infrastructure.output.persistence.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SalePersistenceServiceImpl implements SalePersistenceService {

    @Autowired
    @Qualifier("userReferenceById")
    private UserSelector<String> userReferenceById;
    @Autowired
    @Qualifier("productReferenceById")
    private ProductSelector<String> productsReferenceById;

    @Autowired
    private ProductsByUser productRepository;

    @Override
    public Sale save(SalePostReqDTO sale) {
        /*
        TODO
            Client exists

            All products exists

            Create sale

            Save sale
         */
        //get reference
        User user = this.userReferenceById.get(sale.getClientId());
        List<Product> productEntities = new ArrayList<>();
        for (String productId : sale.getProducts() ) {
            Product productEntity = this.productsReferenceById.get(productId);
            productEntities.add(productEntity);
           //TODO update product quantity after sale this.productService.updateQuantity( productEntity.getId(), 1D);
        }

        Double totalPrice = 0D;
       /*

       TODO update total price
       for (ProductEntity productEntity : productEntities) {
            totalPrice += productEntity.getPrice();
        }*/

       // return this.jpaMySQLSaleRepository.save(new SaleEntity(userEntity, productEntities, totalPrice));
        return null;

    }

    @Override
    public Sale update(Sale sale) {/*
        Optional<SaleEntity> saleOptional = this.jpaMySQLSaleRepository.findById(body.getSaleId());
        if (saleOptional.isPresent()) {
            SaleEntity saleEntity = saleOptional.get();
            UserEntity userEntity = this.userService.getById(body.getClientId());
            saleEntity.setClient(userEntity);
            return this.jpaMySQLSaleRepository.save(saleEntity);

        }
        throw new NotFoundException("SaleEntity not found");*/
        return null;


    }
}
