package com.joel.spring.sales.application.usecases;

import com.joel.spring.product.application.dto.ProductInfoDTO;
import com.joel.spring.dtos.sales.SaleMaxAmountDTO;
import com.joel.spring.sales.application.port.output.SaleServiceRepositoryPort;
import com.joel.spring.sales.application.port.input.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

// TODO CAMBIAR STOCK DE PRODUCTOS AL REALIZAR UNA VENTA, Y FIJARSE QUE EL PRODUCTO ES TE DISPONIBLE
@Service
public class SaleServiceImpl implements SaleService {
    @Autowired private SaleServiceRepositoryPort saleRepository;

    @Override
    public List<ProductInfoDTO> getProducts(String id) {
        return this.saleRepository.getProductsSale(id);
    }

    @Override
    public List<SaleMaxAmountDTO> getMaxAmountSale() {
        return this.saleRepository.maxAmountSale();

    }

}
