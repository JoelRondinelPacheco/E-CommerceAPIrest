package com.joel.spring.sales.adapter.output.persistence.selector;

import com.joel.spring.sales.adapter.output.persistence.SaleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository
public interface SaleSelectorRepository extends JpaRepository<SaleEntity, String> {
}
