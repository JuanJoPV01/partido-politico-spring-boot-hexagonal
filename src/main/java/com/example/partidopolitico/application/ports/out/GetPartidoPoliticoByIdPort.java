package com.example.partidopolitico.application.ports.out;

import com.example.partidopolitico.domain.PartidoPolitico;
import com.example.partidopolitico.domain.PartidoPoliticoId;

public interface GetPartidoPoliticoByIdPort {

    PartidoPolitico findById(PartidoPoliticoId id);
}