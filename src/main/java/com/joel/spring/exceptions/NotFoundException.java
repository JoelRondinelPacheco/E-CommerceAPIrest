package com.joel.spring.exceptions;

public class NotFoundException extends Exception{
    public NotFoundException(String msg) {
        super(msg);
    }
}