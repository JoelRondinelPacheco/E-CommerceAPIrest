package com.joel.spring.services;

import com.joel.spring.dtos.sales.*;
import com.joel.spring.entities.Client;
import com.joel.spring.entities.Product;
import com.joel.spring.entities.Sale;
import com.joel.spring.exceptions.NotFoundException;
import com.joel.spring.repositories.ISaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

// TODO CAMBIAR STOCK DE PRODUCTOS AL REALIZAR UNA VENTA, Y FIJARSE QUE EL PRODUCTO ES TE DISPONIBLE
@Service
public class SaleService implements ICrudService<Sale, SalePostReqDTO, SaleEditReqDTO, Long> {
    @Autowired
    private ISaleRepository saleRepository;
    @Autowired
    private ClientService clientService;
    @Autowired
    private ProductService productService;

    @Override
    public Sale getById(Long id) throws NotFoundException {
        Optional<Sale> saleOptional = this.saleRepository.findById(id);
        if (saleOptional.isPresent()) {
            Sale sale = saleOptional.get();
            return sale;
        }
        throw new NotFoundException("Sale not found");
    }

    @Override
    public Sale save(SalePostReqDTO body) throws NotFoundException {
        Client client = this.clientService.getById(body.getClient_id());
        List<Product> products = new ArrayList<>();
        for (Long product_id : body.getProducts() ) {
            Product product = this.productService.getById(product_id);
            products.add(product);
            this.productService.updateQuantity( product.getProduct_id(), 1D);
        }

        Double totalPrice = 0D;
        for (Product product : products) {
            totalPrice += product.getPrice();
        }

        Sale sale = this.saleRepository.save(new Sale(client, products, totalPrice));
        return sale;
    }

    @Override
    public String delete(Long id) {
        this.saleRepository.deleteById(id);
        return "Product deleted";
    }

    @Override
    public Sale update(SaleEditReqDTO body) throws NotFoundException {
        // TODO VER QUE ERROR GENERA AL PEDIR UNA VENTA CON ID QUE NO EXISTE
        Sale sale = this.saleRepository.findById(body.getSale_id()).get();
        Client client = this.clientService.getById(body.getClient_id());
        sale.setClient(client);
        //sale.setTotal_price(body.getTotal_price());
        this.saleRepository.save(sale);
        return sale;

    }

    @Override
    public List<Sale> getAll() {
        return this.saleRepository.findAll();
    }

    public List<Product> getProducts(Long id) {
        return this.saleRepository.findProductsBySaleId(id);
    }

    //TODO PUNTO 6 QUERY DE TOTAL VENTAS POR FECHA
    public SaleInfoByDateDTO getSaleInfoByDate(Date date) {
        Double total_amount = this.saleRepository.totalAmountByDate(date);
        int total_sales = this.saleRepository.countSalesByDate(date);
        return new SaleInfoByDateDTO(total_amount, total_sales);
    }

    public List<SaleMaxAmountDTO> getMaxAmountSale(){
        List<SaleMaxAmountDTO> max = this.saleRepository.saleMaxAmount();
        return this.saleRepository.saleMaxAmount();
    }
}
