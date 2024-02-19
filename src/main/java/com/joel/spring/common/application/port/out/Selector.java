package com.joel.spring.common.application.port.out;

public interface Selector <R, Q> {
    R getBy(Q q);
}
