package com.br.larissa.crudvendas.controller;

import com.br.larissa.crudvendas.model.ProdutoVenda;
import com.br.larissa.crudvendas.model.Venda;
import com.br.larissa.crudvendas.service.ProdutoVendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtoVenda")
public class ProdutoVendaController {

    @Autowired
    private ProdutoVendaService produtoVendaService;


    @PostMapping
    public ResponseEntity<Object> gravarProdutoVenda(@RequestBody ProdutoVenda produtoVenda){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoVendaService.gravarProdutoVenda(produtoVenda));
    }

    @GetMapping
    public ResponseEntity<List<ProdutoVenda>> listarProdutoVenda(){
        return ResponseEntity.status(HttpStatus.OK).body(produtoVendaService.listarProdutoVendas());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> listarProdutoVendaId(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(produtoVendaService.buscarProdutoVendaId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarProdutoVendaId(@PathVariable(value = "id") Integer id, @RequestBody ProdutoVenda produtoVenda) {
        try {
            ProdutoVenda produtoVendaAtualizada = produtoVendaService.atualizarProdutoVendaId(id)
                    .orElseThrow(() -> new RuntimeException("Produto Venda não encontrada!"));

            produtoVendaAtualizada.setQt_produto(produtoVenda.getQt_produto());
            produtoVendaAtualizada.setVl_total(produtoVenda.getVl_total());
            produtoVendaAtualizada.setVl_unitario(produtoVenda.getVl_unitario());

            return ResponseEntity.status(HttpStatus.OK).body(produtoVendaService.gravarProdutoVenda(produtoVendaAtualizada));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar a requisição");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarProdutoVendaId(@PathVariable(value = "id") Integer id) {

        Optional<ProdutoVenda> produtoVenda = produtoVendaService.buscarProdutoVendaId(id);
        if (produtoVenda.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Produto Venda não localizada!");
        }

        produtoVendaService.deletarProdutoVenda(produtoVenda);

        return ResponseEntity.status(HttpStatus.OK).body("Produto venda deletada com sucesso!");
    }
}
