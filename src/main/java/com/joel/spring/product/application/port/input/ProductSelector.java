package com.joel.spring.product.application.port.input;

import com.joel.spring.product.dto.ProductInfoDTO;

import java.util.List;

public interface ProductSelector <R, T>{
    R get(T t);
}
