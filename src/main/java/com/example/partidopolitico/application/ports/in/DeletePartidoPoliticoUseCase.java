package com.example.partidopolitico.application.ports.in;

import com.example.partidopolitico.domain.PartidoPoliticoId;

public interface DeletePartidoPoliticoUseCase {

    void delete(PartidoPoliticoId id);
}