package com.br.larissa.crudvendas.dto;

import com.br.larissa.crudvendas.model.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ProductRequestDTO(
        @NotBlank
        String name,

        @NotNull
        Integer price,

        @NotNull
        LocalDate dt_validade
) {
}
