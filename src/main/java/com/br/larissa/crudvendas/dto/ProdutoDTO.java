package com.br.larissa.crudvendas.dto;

import com.br.larissa.crudvendas.model.Categoria;

import java.time.LocalDate;

public record ProdutoDTO(String nm_produto, LocalDate dt_validade, Double vl_preco, Categoria id_categoria) {
}
