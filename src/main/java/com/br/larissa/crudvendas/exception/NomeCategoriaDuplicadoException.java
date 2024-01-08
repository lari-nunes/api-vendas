package com.br.larissa.crudvendas.exception;

public class NomeCategoriaDuplicadoException extends RuntimeException {

    public NomeCategoriaDuplicadoException(String mensagem) {
        super(mensagem);
    }
}