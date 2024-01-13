package com.br.larissa.crudvendas.exception;

public class PrecoProdutoNuloException extends RuntimeException{

        public PrecoProdutoNuloException() {
            super();
        }

        public PrecoProdutoNuloException(String message) {
            super(message);
        }

        public PrecoProdutoNuloException(String message, Throwable cause) {
            super(message, cause);
        }
}
