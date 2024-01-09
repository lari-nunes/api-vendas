package com.br.larissa.crudvendas.service;

import com.br.larissa.crudvendas.exception.NomeCategoriaDuplicadoException;
import com.br.larissa.crudvendas.model.Categoria;
import com.br.larissa.crudvendas.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria gravarCategoria(Categoria categoria) {
        if (categoriaRepository.existsByNome(categoria.getNome()).orElse(false)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe uma categoria com esse nome");
        }
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> listarCategorias(){
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> buscarCategoriaId(Integer id){
        return categoriaRepository.findById(id);
    }

    public Optional<Categoria> atualizarCategoriaId(Integer id){
        return categoriaRepository.findById(id);
    }

    public void deletarCategoria(Optional<Categoria> categoria){
        categoriaRepository.delete(categoria.get());
    }
}
