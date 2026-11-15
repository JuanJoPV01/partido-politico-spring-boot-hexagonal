package com.example.partidopolitico.application.commands;

import com.example.partidopolitico.domain.PartidoPolitico;
import com.example.partidopolitico.domain.PartidoPoliticoEslogan;
import com.example.partidopolitico.domain.PartidoPoliticoId;
import com.example.partidopolitico.domain.PartidoPoliticoNombre;

import java.util.UUID;

public record PartidoPoliticoCommand(
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
        int numCongresistas
) {

    public PartidoPolitico toDomain() {
        return new PartidoPolitico.PartidoPoliticoBuilder()
                .id(PartidoPoliticoId.of(UUID.randomUUID().toString()))
                .nombre(PartidoPoliticoNombre.of(nombre))
                .eslogan(PartidoPoliticoEslogan.of(eslogan))
                .presidente(presidente)
                .secretario(secretario)
                .tesorero(tesorero)
                .pais(pais)
                .numPresidentes(numPresidentes)
                .numGobernadores(numGobernadores)
                .numAlcaldes(numAlcaldes)
                .numConcejales(numConcejales)
                .numCongresistas(numCongresistas)
                .activo(true)
                .build();
    }

    public PartidoPolitico toUpdatedDomain(PartidoPolitico existente) {
        return existente.actualizar(
                nombre,
                eslogan,
                presidente,
                secretario,
                tesorero,
                pais,
                numPresidentes,
                numGobernadores,
                numAlcaldes,
                numConcejales,
                numCongresistas
        );
    }
}