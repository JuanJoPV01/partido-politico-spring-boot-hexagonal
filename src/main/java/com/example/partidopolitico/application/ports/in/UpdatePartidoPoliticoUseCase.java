package com.example.partidopolitico.application.ports.in;

import com.example.partidopolitico.domain.PartidoPolitico;
import com.example.partidopolitico.domain.PartidoPoliticoId;
import com.example.partidopolitico.application.ports.out.SavePartidoPoliticoPort;
import com.example.partidopolitico.application.ports.out.GetPartidoPoliticoByIdPort;

public interface UpdatePartidoPoliticoUseCase {

    PartidoPolitico execute(PartidoPoliticoId id, PartidoPolitico partidoPolitico);
}