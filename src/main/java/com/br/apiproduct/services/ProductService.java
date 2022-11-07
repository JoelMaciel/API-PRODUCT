package com.br.apiproduct.services;

import com.br.apiproduct.entities.Product;

import java.util.List;

public interface ProductService {

    List<Product> findALl();
    Product save(Product product);
    void delete(Long id);
}
