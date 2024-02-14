package com.joel.spring.cartproduct.application.port.output;

public interface CartProductSelector <R, T> {
    R get(T t);

}
