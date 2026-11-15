package com.example.partidopolitico.application.ports.in;

import com.example.partidopolitico.domain.PartidoPoliticoId;
import com.example.partidopolitico.application.ports.out.GetPartidoPoliticoByIdPort;

public interface DeletePartidoPoliticoUseCase {

    void execute(PartidoPoliticoId id);
}