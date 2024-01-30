package com.br.larissa.crudvendas.controller;

import com.br.larissa.crudvendas.dto.ProductRequestDTO;
import com.br.larissa.crudvendas.dto.ProductResponseDTO;
import com.br.larissa.crudvendas.model.Product;
import com.br.larissa.crudvendas.repository.ProductRepository;
import com.br.larissa.crudvendas.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private ProdutoService produtoService;

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

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value = "id") String id, @RequestBody Product product) {
        try {
            Optional<Product> produto1 = produtoService.atualizaProdutoId(id);

            if (produto1.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body("Produto não encontrado!");
            }

            Product produto2 = produto1.get();
            produto2.setName(product.getName());
            produto2.setPrice(product.getPrice());
            produto2.setDt_validade(product.getDt_validade());
            produto2.setCategoria(product.getCategoria());

            Product produtoAtualizado = produtoService.gravarProduto(produto2);
            return ResponseEntity.status(HttpStatus.OK).body(produtoAtualizado);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar a requisição");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarProdutoId(@PathVariable(value = "id") String id) {

        Optional<Product> produto = produtoService.buscarProdutoId(id);
        if (produto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Não localizado!");
        }

        produtoService.deletarProdutoId(produto);

        return ResponseEntity.status(HttpStatus.OK).body("Produto deletado com sucesso!");
    }
}
