package com.example.partidopolitico.domain.Exceptions;

public class InvalidPartidoPoliticoIdException extends RuntimeException {

    public InvalidPartidoPoliticoIdException(String detail) {
        super("ID de PartidoPolítico inválido: " + detail);
    }
}