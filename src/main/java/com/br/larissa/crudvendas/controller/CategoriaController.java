package com.br.larissa.crudvendas.controller;

import com.br.larissa.crudvendas.model.Categoria;
import com.br.larissa.crudvendas.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Object> gravarCategoria(@RequestBody Categoria categoria){
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.gravarCategoria(categoria));
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listarCategorias(){
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.listarCategorias());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> listarCategoriaId(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(categoriaService.buscarCategoriaId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarCategoriaId(@PathVariable(value = "id") Integer id, @RequestBody Categoria categoria) {
        try {
            Optional<Categoria> categoria1 = categoriaService.atualizarCategoriaId(id);

            if (categoria1.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body("Categoria não encontrada!");
            }

            Categoria categoria2 = categoria1.get();
            categoria2.setNm_categoria(categoria.getNm_categoria());

            Categoria categoriaAtualizada = categoriaService.gravarCategoria(categoria2);
            return ResponseEntity.status(HttpStatus.OK).body(categoriaAtualizada);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar a requisição");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarCategoriaId(@PathVariable(value = "id") Integer id) {

        Optional<Categoria> categoria = categoriaService.buscarCategoriaId(id);
        if (categoria.isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body("Não localizado!");
        }

        categoriaService.deletarCategoria(categoria);

        return ResponseEntity.status(HttpStatus.OK).body("Categoria deletado com sucesso!");
    }
}
