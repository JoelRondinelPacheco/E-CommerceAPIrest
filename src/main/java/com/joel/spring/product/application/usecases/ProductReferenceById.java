package com.joel.spring.product.application.usecases;

import com.joel.spring.product.application.port.input.ProductSelector;
import com.joel.spring.product.domain.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("productReferenceById")
public class ProductReferenceById implements ProductSelector<String> {
    //inyectar repo
    @Override
    public Product get(String s) {
        return null;
    }
}
