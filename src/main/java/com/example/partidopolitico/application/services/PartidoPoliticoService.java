package com.example.partidopolitico.application.services;

import com.example.partidopolitico.application.ports.in.*;
import com.example.partidopolitico.application.ports.out.*;
import com.example.partidopolitico.domain.PartidoPolitico;
import com.example.partidopolitico.domain.PartidoPoliticoId;
import com.example.partidopolitico.application.mappers.PartidoPoliticoMapper;
import com.example.partidopolitico.domain.Exceptions.*;
import java.util.List;
import java.util.stream.Collectors;

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

    public PartidoPoliticoService(
            SavePartidoPoliticoPort savePartidoPoliticoPort,
            GetPartidoPoliticoByIdPort getPartidoPoliticoByIdPort,
            GetAllPartidosPoliticosPort getAllPartidosPoliticosPort) {
        this.savePartidoPoliticoPort = savePartidoPoliticoPort;
        this.getPartidoPoliticoByIdPort = getPartidoPoliticoByIdPort;
        this.getAllPartidosPoliticosPort = getAllPartidosPoliticosPort;
    }

    @Override
    public PartidoPolitico execute(PartidoPolitico partidoPolitico) {
        validarDuplicidad(partidoPolitico.nombre());
        PartidoPolitico guardado = savePartidoPoliticoPort.save(partidoPolitico);
        return guardado;
    }

    @Override
    public PartidoPolitico execute(PartidoPoliticoId id) {
        return getPartidoPoliticoByIdPort.findById(id);
    }

    @Override
    public void execute(PartidoPoliticoId id) {
        PartidoPolitico existente = getPartidoPoliticoByIdPort.findById(id);
        // Logic would depend on whether soft delete or hard delete
        throw new UnsupportedOperationException("Delete operation not fully implemented");
    }

    @Override
    public PartidoPolitico execute(PartidoPoliticoId id, PartidoPolitico partidoPolitico) {
        PartidoPolitico existente = getPartidoPoliticoByIdPort.findById(id);
        PartidoPolitico actualizado = existente.actualizar(
                partidoPolitico.nombre().value(),
                partidoPolitico.eslogan().value(),
                partidoPolitico.presidente(),
                partidoPolitico.secretario(),
                partidoPolitico.tesorero(),
                partidoPolitico.pais(),
                partidoPolitico.numPresidentes(),
                partidoPolitico.numGobernadores(),
                partidoPolitico.numAlcaldes(),
                partidoPolitico.numConcejales(),
                partidoPolitico.numCongresistas()
        );
        return savePartidoPoliticoPort.save(actualizado);
    }

    @Override
    public List<PartidoPolitico> execute() {
        return getAllPartidosPoliticosPort.findAll().stream()
                .collect(Collectors.toList());
    }

    private void validarDuplicidad(PartidoPoliticoNombre nombre) {
        // Validation logic - in a real implementation would check the repository
        // For now, throw if already exists pattern
        throw new PartidoPoliticoAlreadyExistsException(nombre);
    }
}