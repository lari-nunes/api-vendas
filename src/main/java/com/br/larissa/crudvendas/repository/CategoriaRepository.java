package com.br.larissa.crudvendas.repository;

import com.br.larissa.crudvendas.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

    boolean existsByNm_categoria(String nm_categoria);

}
