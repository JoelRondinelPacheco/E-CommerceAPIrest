package com.joel.spring.product.application.usecases.selector;

import com.joel.spring.product.application.port.input.ProductSelector;
import com.joel.spring.product.application.port.output.ProductSelectorPort;
import com.joel.spring.product.application.dto.ProductInfoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("productById")
public class ProductById implements ProductSelector<ProductInfoDTO, String> {

    @Autowired
    private ProductSelectorPort productSelector;

    @Override
    public ProductInfoDTO get(String id) {
        return this.productSelector.getById(id);
    }
}
