package com.br.larissa.crudvendas.dto;

public record ProdutoVendaDTO(Long id,
                              Integer qt_produto,
                              Double vl_total,
                              Double vl_unitario,
                              Long id_venda,
                              Long id_produto) {
}
