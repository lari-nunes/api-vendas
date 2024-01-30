package com.br.larissa.crudvendas.controller;

import com.br.larissa.crudvendas.dto.ProductRequestDTO;
import com.br.larissa.crudvendas.dto.ProductResponseDTO;
import com.br.larissa.crudvendas.model.Product;
import com.br.larissa.crudvendas.repository.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping
    public ResponseEntity postProduct(@RequestBody @Valid ProductRequestDTO body){
        Product newProduct = new Product(body);
        Product savedProduct = this.productRepository.save(newProduct);
        return ResponseEntity.ok(savedProduct);
    }

    @GetMapping
    public ResponseEntity getAllProduct(){
        List<ProductResponseDTO> productList = this.productRepository.findAll().stream().map(ProductResponseDTO::new).toList();
        return ResponseEntity.ok(productList);
    }
}
