package com.joel.spring.product.application.usecases;

import com.joel.spring.product.application.port.input.ProductSelector;
import com.joel.spring.product.domain.Product;
import com.joel.spring.product.dto.ProductInfoDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("productReferenceById")
public class ProductReferenceById implements ProductSelector<Product, String> {
    @Override
    public Product get(String s) {
        return null;
    }
    //inyectar repo

}
