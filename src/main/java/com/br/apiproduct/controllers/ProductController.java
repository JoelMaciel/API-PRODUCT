package com.br.apiproduct.controllers;

import com.br.apiproduct.entities.Product;
import com.br.apiproduct.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/products")
public class ProductController {

    private  final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        var products = productService.findALl();
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product) {
        var newProduct = productService.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(newProduct);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}








