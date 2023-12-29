package com.br.larissa.crudvendas.repository;

import com.br.larissa.crudvendas.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Integer> {
}
