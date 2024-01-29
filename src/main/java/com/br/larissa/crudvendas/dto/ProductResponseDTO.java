package com.br.larissa.crudvendas.dto;

import com.br.larissa.crudvendas.model.Product;

public record ProductResponseDTO(String id, String name, Integer price) {
    public ProductResponseDTO(Product product){
        this(product.getId(), product.getName(), product.getPrice());
    }
}

