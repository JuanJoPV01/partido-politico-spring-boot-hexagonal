package com.example.partidopolitico.application.mappers;

import com.example.partidopolitico.application.commands.PartidoPoliticoCommand;
import com.example.partidopolitico.application.responses.PartidoPoliticoResponse;
import com.example.partidopolitico.domain.PartidoPolitico;

public class PartidoPoliticoMapper {

    public static PartidoPoliticoResponse toResponse(PartidoPolitico partidoPolitico) {
        return PartidoPoliticoResponse.fromDomain(partidoPolitico);
    }

    public static PartidoPolitico toCommand(PartidoPoliticoCommand command) {
        return command.toDomain();
    }

    public static PartidoPolitico toUpdatedCommand(PartidoPoliticoCommand command, PartidoPolitico existing) {
        return command.toUpdatedDomain(existing);
    }
}