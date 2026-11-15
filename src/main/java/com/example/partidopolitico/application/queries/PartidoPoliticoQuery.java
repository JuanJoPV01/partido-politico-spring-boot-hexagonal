package com.example.partidopolitico.application.queries;

import com.example.partidopolitico.domain.PartidoPolitico;
import java.util.List;

public record PartidoPoliticoQuery() {

    public static List<PartidoPolitico> fromDomain(List<PartidoPolitico> partidos) {
        return partidos;
    }
}