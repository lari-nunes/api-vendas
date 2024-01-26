package com.br.larissa.crudvendas.dto;

import com.br.larissa.crudvendas.model.Categoria;
import com.br.larissa.crudvendas.model.Produto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ProdutoResponseDTO(Integer id_produto, String nm_produto, LocalDate dt_validade, Double vl_preco) {
    public ProdutoResponseDTO(Produto produto){
        this(produto.getId_produto(), produto.getNm_produto(), produto.getDt_validade(), produto.getVl_preco());
    }
}
