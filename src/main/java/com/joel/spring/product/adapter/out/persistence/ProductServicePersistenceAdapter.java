package com.joel.spring.product.adapter.out.persistence;

import com.joel.spring.product.application.dto.ProductInfoDTO;
import com.joel.spring.product.application.dto.UpdateStockDTO;
import com.joel.spring.product.application.port.output.ProductServicePort;
import com.joel.spring.product.domain.Product;
import com.joel.spring.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.annotation.AccessType;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServicePersistenceAdapter implements ProductServicePort {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductDTORepository productDTORepository;

    @Autowired
    @Qualifier("productMapper")
    private Mapper<ProductEntity, Product> mapper;


    @Override
    public Product updateStock(UpdateStockDTO productStockDTO) {
        //TODO REFACTOR RETURN TYPE??
        //SE PUEDE LLAMAR AL PORT DE LA APP??
        this.productRepository.updateStock(productStockDTO.getProductId(), productStockDTO.getNewStock());
        return this.mapper.entityToDomain(this.productRepository.findById(productStockDTO.getProductId()).get());
    }

    @Override
    public List<ProductInfoDTO> lowStockProducts(Long stock) {
        return this.productDTORepository.getLowStock(stock);
    }
}
