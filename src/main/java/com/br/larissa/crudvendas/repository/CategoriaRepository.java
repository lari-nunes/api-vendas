package com.br.larissa.crudvendas.repository;

import com.br.larissa.crudvendas.model.Categoria;
import com.br.larissa.crudvendas.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    Optional<Boolean> existsByNome(String nome);

}
