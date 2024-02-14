package com.joel.spring.product.application.usecases.selector;

import com.joel.spring.product.application.port.input.ProductSelector;
import com.joel.spring.product.application.port.output.ProductSelectorPort;
import com.joel.spring.product.dto.ProductInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AllProducts implements ProductSelector<List<ProductInfoDTO>, String> {
    @Autowired
    private ProductSelectorPort productSelector;
    @Override
    public List<ProductInfoDTO> get(String s) {
        return this.productSelector.getAll();
    }
}
