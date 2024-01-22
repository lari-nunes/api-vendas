package com.br.larissa.crudvendas.dto;

import com.br.larissa.crudvendas.model.Produto;
import com.br.larissa.crudvendas.model.Venda;

public record ProdutoVendaDTO(Integer id_produto_venda, Integer qt_produto, Double vl_total, Double vl_unitario, Venda id_venda, Produto id_produto) {
}
