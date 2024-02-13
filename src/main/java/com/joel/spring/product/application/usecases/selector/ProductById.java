package com.joel.spring.product.application.usecases.selector;

import com.joel.spring.product.application.port.input.ProductSelector;
import com.joel.spring.product.dto.ProductInfoDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Qualifier("productById")
public class ProductById implements ProductSelector<String> {
    @Override
    public List<ProductInfoDTO> get(String s) {
        return null;
    }
}
