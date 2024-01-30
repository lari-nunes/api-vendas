package com.br.larissa.crudvendas.dto;

import com.br.larissa.crudvendas.model.Product;

import java.time.LocalDate;

public record ProductResponseDTO(String id, String name, Integer price, LocalDate dt_validade) {
    public ProductResponseDTO(Product product){
        this(product.getId(), product.getName(), product.getPrice(), product.getDt_validade());
    }


}

