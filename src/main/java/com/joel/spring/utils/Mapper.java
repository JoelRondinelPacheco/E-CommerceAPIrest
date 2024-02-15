package com.joel.spring.utils;

public interface Mapper<E, D> {
    //TODO COMPLETAR TODAS LAS IMPLEMENTACION
    D entityToDomain(E e);
    E domainToEntity(D d);
}
