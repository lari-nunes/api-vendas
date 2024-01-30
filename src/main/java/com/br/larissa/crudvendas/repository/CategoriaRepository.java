package com.br.larissa.crudvendas.repository;

import com.br.larissa.crudvendas.model.Categoria;
import com.br.larissa.crudvendas.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
    Optional<Boolean> existsByNome(String nome);
}
