package com.joel.spring.category.application.port.input;

import com.joel.spring.category.domain.Category;

public interface CategorySelector <T> {
    Category get(T t);
}
