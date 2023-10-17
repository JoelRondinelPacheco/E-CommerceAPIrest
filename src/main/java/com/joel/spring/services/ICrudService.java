package com.joel.spring.services;

import com.joel.spring.dtos.sales.SalePostResDTO;
import com.joel.spring.exceptions.NotFoundException;

import java.util.List;

public interface ICrudService<T, TPostDTO, TEditDTO, ID> {
    public T getById(ID id) throws NotFoundException;
    public T save(TPostDTO dto) throws NotFoundException;
    public String delete(ID id);
    public T update(TEditDTO dto) throws NotFoundException;
    public List<T> getAll();

}
