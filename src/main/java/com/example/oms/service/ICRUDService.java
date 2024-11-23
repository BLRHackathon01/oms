package com.example.oms.service;

import java.util.List;

public interface ICRUDService<T, ID> {
    List<T> findAll();
    T save(T entity);
    T findById(ID id);
    void delete(T entity);
    void deleteById(ID id);
    long count();
}