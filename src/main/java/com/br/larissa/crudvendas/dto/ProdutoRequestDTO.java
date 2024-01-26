package com.br.larissa.crudvendas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoRequestDTO(
        @NotBlank
        String name,

        @NotNull
        Integer price
) {
}
