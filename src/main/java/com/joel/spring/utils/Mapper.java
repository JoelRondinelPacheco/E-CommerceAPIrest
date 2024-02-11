package com.joel.spring.utils;

public interface Mapper<E, D> {
    D entityToDomain(E e);
    E domainToEntity(D d);
}
