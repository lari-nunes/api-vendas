package com.br.larissa.crudvendas.service;

import com.br.larissa.crudvendas.model.Categoria;
import com.br.larissa.crudvendas.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria gravarCategoria(Categoria categoria){
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
