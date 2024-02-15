package com.joel.spring.product.adapter.out.persistence;

import com.joel.spring.product.application.dto.ProductInfoDTO;
import com.joel.spring.product.application.dto.UpdateStockDTO;
import com.joel.spring.product.application.port.output.ProductServicePort;
import com.joel.spring.product.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServicePersistenceAdapter implements ProductServicePort {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductDTORepository productDTORepository;

    @Override
    public Product update(UpdateStockDTO productStockDTO) {
        return null;
    }

    @Override
    public List<ProductInfoDTO> lowStockProducts(Long stock) {
        return this.productDTORepository.getLowStock(stock);
    }
}
