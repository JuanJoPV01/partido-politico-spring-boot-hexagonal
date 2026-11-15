package com.example.partidopolitico.application.ports.in;

import com.example.partidopolitico.domain.PartidoPolitico;
import java.util.List;
import com.example.partidopolitico.application.ports.out.GetAllPartidosPoliticosPort;

public interface GetAllPartidosPoliticosUseCase {

    List<PartidoPolitico> execute();
}