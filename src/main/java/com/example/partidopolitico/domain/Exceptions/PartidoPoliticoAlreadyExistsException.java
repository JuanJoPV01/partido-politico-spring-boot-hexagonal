package com.example.partidopolitico.domain.Exceptions;

import com.example.partidopolitico.domain.PartidoPoliticoNombre;

public class PartidoPoliticoAlreadyExistsException extends RuntimeException {

    public PartidoPoliticoAlreadyExistsException(PartidoPoliticoNombre nombre) {
        super("Ya existe un PartidoPolítico con el nombre: " + nombre);
    }
}