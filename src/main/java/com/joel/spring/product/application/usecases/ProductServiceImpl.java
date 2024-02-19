package com.joel.spring.product.application.usecases;

import com.joel.spring.product.application.port.input.ProductService;
import com.joel.spring.product.application.port.output.ProductServicePort;
import com.joel.spring.product.domain.Product;
import com.joel.spring.product.application.dto.ProductInfoDTO;
import com.joel.spring.product.application.dto.UpdateStockDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductServicePort productServicePort;
    @Override
    public ProductInfoDTO updateStock(UpdateStockDTO newStock) {
        this.productServicePort.updateStock(newStock);

        return null;
    }

    @Override
    public List<ProductInfoDTO> lowStockProducts(Long stock) {
        return null;
    }
}
