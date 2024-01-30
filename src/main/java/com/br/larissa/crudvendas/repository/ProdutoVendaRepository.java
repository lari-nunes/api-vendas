package com.br.larissa.crudvendas.repository;

import com.br.larissa.crudvendas.model.ProdutoVenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoVendaRepository extends JpaRepository<ProdutoVenda, Integer> {
}
