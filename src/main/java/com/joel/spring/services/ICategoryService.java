package com.joel.spring.services;

import com.joel.spring.entities.Category;
import com.joel.spring.exceptions.NotFoundException;

import java.util.List;

public interface ICategoryService {
    List<Category> getListCategoriesById(List<String> categoriesId);
    Category getCategoryById(String id) throws NotFoundException;
}
