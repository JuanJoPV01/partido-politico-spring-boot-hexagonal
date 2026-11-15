package com.example.partidopolitico.application.responses;

import com.example.partidopolitico.domain.PartidoPolitico;

import java.time.LocalDateTime;

public record PartidoPoliticoResponse(
        String id,
        String nombre,
        String eslogan,
        String presidente,
        String secretario,
        String tesorero,
        String pais,
        int numPresidentes,
        int numGobernadores,
        int numAlcaldes,
        int numConcejales,
        int numCongresistas,
        boolean activo,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static PartidoPoliticoResponse fromDomain(PartidoPolitico partidoPolitico) {
        return new PartidoPoliticoResponse(
                partidoPolitico.id().value(),
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
                partidoPolitico.numCongresistas(),
                partidoPolitico.activo(),
                partidoPolitico.createdAt(),
                partidoPolitico.updatedAt()
        );
    }
}