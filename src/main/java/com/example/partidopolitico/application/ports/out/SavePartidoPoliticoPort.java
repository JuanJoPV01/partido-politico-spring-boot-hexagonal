package com.example.partidopolitico.application.ports.out;

import com.example.partidopolitico.domain.PartidoPolitico;

public interface SavePartidoPoliticoPort {

 PartidoPolitico save(PartidoPolitico partidoPolitico);
}