package com.example.partidopolitico.application.services;

import com.example.partidopolitico.application.ports.in.CreatePartidoPoliticoUseCase;
import com.example.partidopolitico.application.ports.in.DeletePartidoPoliticoUseCase;
import com.example.partidopolitico.application.ports.in.GetAllPartidosPoliticosUseCase;
import com.example.partidopolitico.application.ports.in.GetPartidoPoliticoByIdUseCase;
import com.example.partidopolitico.application.ports.in.UpdatePartidoPoliticoUseCase;
import com.example.partidopolitico.application.ports.out.DeletePartidoPoliticoPort;
import com.example.partidopolitico.application.ports.out.GetAllPartidosPoliticosPort;
import com.example.partidopolitico.application.ports.out.GetPartidoPoliticoByIdPort;
import com.example.partidopolitico.application.ports.out.SavePartidoPoliticoPort;
import com.example.partidopolitico.domain.PartidoPolitico;
import com.example.partidopolitico.domain.PartidoPoliticoId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidoPoliticoService implements
        CreatePartidoPoliticoUseCase,
        GetPartidoPoliticoByIdUseCase,
        DeletePartidoPoliticoUseCase,
        UpdatePartidoPoliticoUseCase,
        GetAllPartidosPoliticosUseCase {

    private final SavePartidoPoliticoPort savePartidoPoliticoPort;
    private final GetPartidoPoliticoByIdPort getPartidoPoliticoByIdPort;
    private final GetAllPartidosPoliticosPort getAllPartidosPoliticosPort;
    private final DeletePartidoPoliticoPort deletePartidoPoliticoPort;

    public PartidoPoliticoService(
            SavePartidoPoliticoPort savePartidoPoliticoPort,
            GetPartidoPoliticoByIdPort getPartidoPoliticoByIdPort,
            GetAllPartidosPoliticosPort getAllPartidosPoliticosPort,
            DeletePartidoPoliticoPort deletePartidoPoliticoPort) {
        this.savePartidoPoliticoPort = savePartidoPoliticoPort;
        this.getPartidoPoliticoByIdPort = getPartidoPoliticoByIdPort;
        this.getAllPartidosPoliticosPort = getAllPartidosPoliticosPort;
        this.deletePartidoPoliticoPort = deletePartidoPoliticoPort;
    }

    @Override
    public PartidoPolitico execute(PartidoPolitico partidoPolitico) {
        return savePartidoPoliticoPort.save(partidoPolitico);
    }

    @Override
    public PartidoPolitico execute(PartidoPoliticoId id) {
        return getPartidoPoliticoByIdPort.findById(id);
    }

    @Override
    public void delete(PartidoPoliticoId id) {
        deletePartidoPoliticoPort.deleteById(id);
    }

    @Override
    public PartidoPolitico execute(PartidoPoliticoId id, PartidoPolitico cambios) {
        PartidoPolitico existente = getPartidoPoliticoByIdPort.findById(id);
        PartidoPolitico actualizado = existente.actualizar(
                cambios.nombre().value(),
                cambios.eslogan().value(),
                cambios.presidente(),
                cambios.secretario(),
                cambios.tesorero(),
                cambios.pais(),
                cambios.numPresidentes(),
                cambios.numGobernadores(),
                cambios.numAlcaldes(),
                cambios.numConcejales(),
                cambios.numCongresistas()
        );
        return savePartidoPoliticoPort.save(actualizado);
    }

    @Override
    public List<PartidoPolitico> execute() {
        return getAllPartidosPoliticosPort.findAll();
    }
}