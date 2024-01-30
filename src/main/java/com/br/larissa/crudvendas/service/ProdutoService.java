package com.br.larissa.crudvendas.service;

import com.br.larissa.crudvendas.model.Product;
import com.br.larissa.crudvendas.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProductRepository productRepository;

    public Product gravarProduto(Product product){
        return productRepository.save(product);
    }

    public List<Product> listarProdutos(){
        return productRepository.findAll();
    }

    public Optional<Product> buscarProdutoId(String id){
        return productRepository.findById(id);
    }

    public Optional<Product> atualizaProdutoId(String id){
        return productRepository.findById(id);
    }

    public void deletarProdutoId(Optional<Product> product){
        productRepository.delete(product.get());
    }
}
