package com.joel.spring.category.adapter.in.web;

import com.joel.spring.category.application.dto.NewCategoryDTO;
import com.joel.spring.category.application.dto.NewSubCategory;
import com.joel.spring.category.application.port.input.CategoryPersistence;
import com.joel.spring.category.application.port.input.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryPersistence categoryPersistence;

    @PostMapping
    private ResponseEntity<?> addCategory(@RequestBody NewCategoryDTO body) {
        System.out.println(body);
        this.categoryPersistence.newCategory(body);
        System.out.println(body.getName());
        System.out.println(body.getDescription());
        for(NewSubCategory n : body.getSubCategories()) {
            System.out.println(n.getName());
        }
        return ResponseEntity.ok("Ok");
    }
}
