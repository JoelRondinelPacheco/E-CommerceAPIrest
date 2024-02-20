package com.joel.spring.category.adapter.output.persistence.entity;

import com.joel.spring.product.adapter.out.persistence.ProductEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CategoryEntity {
    @Id
    @UuidGenerator
    private String id;
    private String name;
    private String description;
    private Integer displayOrder;

    @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<SubCategoryEntity> subCategories;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "rel_category_product", joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<ProductEntity> products;
}
