package com.example.partidopolitico.application.ports.in;

import com.example.partidopolitico.domain.PartidoPolitico;
import com.example.partidopolitico.application.ports.out.SavePartidoPoliticoPort;

public interface CreatePartidoPoliticoUseCase {

    PartidoPolitico execute(PartidoPolitico partidoPolitico);
}