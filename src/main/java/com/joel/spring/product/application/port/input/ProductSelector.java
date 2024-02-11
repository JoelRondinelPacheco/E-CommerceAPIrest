package com.joel.spring.product.application.port.input;

import com.joel.spring.product.domain.Product;

public interface ProductSelector <T>{
    Product get(T t);
}
