//package com.br.larissa.crudvendas.dto;
//
//import com.br.larissa.crudvendas.model.Produto;
//
//import java.time.LocalDate;
//
//public record ProdutoResponseDTO(String id_produto, String nm_produto, Double vl_preco, LocalDate dt_validade) {
//    public ProdutoResponseDTO(Produto produto){
//        this((produto.getId_produto()), produto.getNm_produto(), produto.getVl_preco(), produto.getDt_validade());
//    }
//}