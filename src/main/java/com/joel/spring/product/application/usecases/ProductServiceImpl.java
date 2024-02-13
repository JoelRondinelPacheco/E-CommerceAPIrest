package com.joel.spring.product.application.usecases;

import com.joel.spring.product.application.port.input.ProductService;
import com.joel.spring.product.application.port.output.UpdateStockPort;
import com.joel.spring.product.domain.Product;
import com.joel.spring.product.dto.UpdateStockDTO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Autowired
    private UpdateStockPort updateStock;
    @Override
    public Product updateStock(UpdateStockDTO newStock) {
        return null;
    }

    @Override
    public List<Product> lowStockProducts(Long stock) {
        return null;
    }
}
