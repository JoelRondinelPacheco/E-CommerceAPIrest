package com.joel.spring.category.application.port.outpout;

import com.joel.spring.category.domain.Category;

public interface CategorySelectorPort {
    Category getById(String id);
}
