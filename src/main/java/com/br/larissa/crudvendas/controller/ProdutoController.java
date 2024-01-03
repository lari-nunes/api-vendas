package com.br.larissa.crudvendas.controller;


import com.br.larissa.crudvendas.model.Produto;
import com.br.larissa.crudvendas.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Object> gravarProduto(@RequestBody Produto produto){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.gravarProduto(produto));
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.listarProdutos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> listarProdutosId(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.buscarProdutoId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarProdutoId(@PathVariable(value = "id") Integer id, @RequestBody Produto produto) {
        try {
            Optional<Produto> produto1 = produtoService.atualizaProdutoId(id);

            if (produto1.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body("Produto não encontrado!");
            }

            Produto produto2 = produto1.get();
            produto2.setNm_produto(produto.getNm_produto());
            produto2.setCategoria(produto.getCategoria());
            produto2.setDt_validade(produto.getDt_validade());
            produto2.setVl_preco(produto.getVl_preco());

            Produto produtoAtualizado = produtoService.gravarProduto(produto2);
            return ResponseEntity.status(HttpStatus.OK).body(produtoAtualizado);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar a requisição");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarProdutoId(@PathVariable(value = "id") Integer id) {

        Optional<Produto> produto = produtoService.buscarProdutoId(id);
        if (produto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Não localizado!");
        }

        produtoService.deletarProdutoId(produto);

        return ResponseEntity.status(HttpStatus.OK).body("Produto deletado com sucesso!");
    }
}
