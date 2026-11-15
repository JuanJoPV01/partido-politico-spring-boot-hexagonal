package com.example.partidopolitico.application.ports.out;

import com.example.partidopolitico.domain.PartidoPolitico;
import java.util.List;

public interface GetAllPartidosPoliticosPort {

    List<PartidoPolitico> findAll();
}