package com.br.larissa.crudvendas.dto;

import com.br.larissa.crudvendas.model.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
