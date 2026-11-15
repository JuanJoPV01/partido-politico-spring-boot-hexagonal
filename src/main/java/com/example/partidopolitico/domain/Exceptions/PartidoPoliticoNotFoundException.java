package com.example.partidopolitico.domain.Exceptions;

import com.example.partidopolitico.domain.PartidoPoliticoId;

public class PartidoPoliticoNotFoundException extends RuntimeException {

    public PartidoPoliticoNotFoundException(PartidoPoliticoId id) {
        super("PartidoPolítico con ID " + id + " no encontrado");
    }
}