package com.br.larissa.crudvendas.repository;

import com.br.larissa.crudvendas.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
