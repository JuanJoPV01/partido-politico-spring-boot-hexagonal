package com.example.partidopolitico.application.ports.out;

import com.example.partidopolitico.domain.PartidoPoliticoId;

public interface DeletePartidoPoliticoPort {

    void deleteById(PartidoPoliticoId id);
}