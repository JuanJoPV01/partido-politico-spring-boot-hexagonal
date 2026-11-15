package com.example.partidopolitico.infrastructure;

import com.example.partidopolitico.domain.PartidoPolitico;
import com.example.partidopolitico.domain.PartidoPoliticoEslogan;
import com.example.partidopolitico.domain.PartidoPoliticoId;
import com.example.partidopolitico.domain.PartidoPoliticoNombre;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "partidos_politicos")
public class PartidoPoliticoEntity {

    @Id
    @Column(name = "id", length = 36, nullable = false, updatable = false)
    private String id;

    @Column(name = "nombre", length = 120, nullable = false)
    private String nombre;

    @Column(name = "eslogan", length = 180, nullable = false)
    private String eslogan;

    @Column(name = "presidente", length = 100, nullable = false)
    private String presidente;

    @Column(name = "secretario", length = 100, nullable = false)
    private String secretario;

    @Column(name = "tesorero", length = 100, nullable = false)
    private String tesorero;

    @Column(name = "pais", length = 80, nullable = false)
    private String pais;

    @Column(name = "num_presidentes", nullable = false)
    private int numPresidentes;

    @Column(name = "num_gobernadores", nullable = false)
    private int numGobernadores;

    @Column(name = "num_alcaldes", nullable = false)
    private int numAlcaldes;

    @Column(name = "num_concejales", nullable = false)
    private int numConcejales;

    @Column(name = "num_congresistas", nullable = false)
    private int numCongresistas;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    protected PartidoPoliticoEntity() {
    }

    static PartidoPoliticoEntity fromDomain(PartidoPolitico partidoPolitico) {
        PartidoPoliticoEntity entidad = new PartidoPoliticoEntity();
        entidad.id = partidoPolitico.id().value();
        entidad.nombre = partidoPolitico.nombre().value();
        entidad.eslogan = partidoPolitico.eslogan().value();
        entidad.presidente = partidoPolitico.presidente();
        entidad.secretario = partidoPolitico.secretario();
        entidad.tesorero = partidoPolitico.tesorero();
        entidad.pais = partidoPolitico.pais();
        entidad.numPresidentes = partidoPolitico.numPresidentes();
        entidad.numGobernadores = partidoPolitico.numGobernadores();
        entidad.numAlcaldes = partidoPolitico.numAlcaldes();
        entidad.numConcejales = partidoPolitico.numConcejales();
        entidad.numCongresistas = partidoPolitico.numCongresistas();
        entidad.createdAt = partidoPolitico.createdAt();
        entidad.updatedAt = partidoPolitico.updatedAt();
        return entidad;
    }

    PartidoPolitico toDomain() {
        return new PartidoPolitico.PartidoPoliticoBuilder()
                .id(PartidoPoliticoId.of(id))
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
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }
}