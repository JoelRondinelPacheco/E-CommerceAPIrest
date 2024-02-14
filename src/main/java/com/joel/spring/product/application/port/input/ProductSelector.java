package com.joel.spring.product.application.port.input;

public interface ProductSelector <R, T>{
    R get(T t);
}
