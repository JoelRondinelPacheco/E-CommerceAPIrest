package com.joel.spring.product.application.usecases.selector;

import com.joel.spring.product.application.port.input.ProductSelector;
import com.joel.spring.product.dto.ProductInfoDTO;

import java.util.List;

public class AllProducts implements ProductSelector<String> {
    @Override
    public List<ProductInfoDTO> get(String s) {
        return null;
    }
}
