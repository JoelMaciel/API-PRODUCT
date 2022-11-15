package com.br.apiproduct.services.impl;

import com.br.apiproduct.entities.Product;
import com.br.apiproduct.repositories.ProductRepository;
import com.br.apiproduct.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProdutoServiceImpl(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findALl() {
       return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {

        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        try {
            productRepository.deleteById(id);
        }catch (Exception e) {
            throw  new RuntimeException("An error occurred while deleting the product.");
        }

    }
}
