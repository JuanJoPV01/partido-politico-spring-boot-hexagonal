package com.example.partidopolitico.infrastructure;

import com.example.partidopolitico.application.ports.out.SavePartidoPoliticoPort;
import com.example.partidopolitico.application.ports.out.GetPartidoPoliticoByIdPort;
import com.example.partidopolitico.application.ports.out.GetAllPartidosPoliticosPort;
import com.example.partidopolitico.domain.PartidoPolitico;
import com.example.partidopolitico.domain.PartidoPoliticoId;
import jakarta.persistence.*;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "partidos_politicos")
public class PartidoPoliticoRepository implements SavePartidoPoliticoPort, GetPartidoPoliticoByIdPort, GetAllPartidosPoliticosPort {

    @Id
    @Column(name = "id", length = 36)
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
    private java.time.LocalDateTime createdAt;

    @Column(name = "updated_at")
    private java.time.LocalDateTime updatedAt;

    public PartidoPoliticoRepository() {}

    public PartidoPoliticoRepository(PartidoPolitico partidoPolitico) {
        this.id = partidoPolitico.id().value();
        this.nombre = partidoPolitico.nombre().value();
        this.eslogan = partidoPolitico.eslogan().value();
        this.presidente = partidoPolitico.presidente();
        this.secretario = partidoPolitico.secretario();
        this.tesorero = partidoPolitico.tesorero();
        this.pais = partidoPolitico.pais();
        this.numPresidentes = partidoPolitico.numPresidentes();
        this.numGobernadores = partidoPolitico.numGobernadores();
        this.numAlcaldes = partidoPolitico.numAlcaldes();
        this.numConcejales = partidoPolitico.numConcejales();
        this.numCongresistas = partidoPolitico.numCongresistas();
        this.createdAt = partidoPolitico.createdAt().toLocalDateTime();
        this.updatedAt = partidoPolitico.updatedAt().toLocalDateTime();
    }

    public PartidoPolitico toDomain() {
        return new PartidoPolitico.PartidoPoliticoBuilder()
                .id(PartidoPoliticoId.of(this.id))
                .nombre(PartidoPoliticoNombre.of(this.nombre))
                .eslogan(PartidoPoliticoEslogan.of(this.eslogan))
                .presidente(this.presidente)
                .secretario(this.secretario)
                .tesorero(this.tesorero)
                .pais(this.pais)
                .numPresidentes(this.numPresidentes)
                .numGobernadores(this.numGobernadores)
                .numAlcaldes(this.numAlcaldes)
                .numConcejales(this.numConcejales)
                .numCongresistas(this.numCongresistas)
                .activo(true)
                .createdAt(java.time.LocalDateTime.of(
                    this.createdAt.getYear(),
                    this.createdAt.getMonthValue(),
                    this.createdAt.getDayOfMonth(),
                    this.createdAt.getHour(),
                    this.createdAt.getMinute()
                ))
                .updatedAt(java.time.LocalDateTime.now())
                .build();
    }

    // Getters and Setters for JPA
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getEslogan() { return eslogan; }
    public void setEslogan(String eslogan) { this.eslogan = eslogan; }
    public String getPresidente() { return presidente; }
    public void setPresidente(String presidente) { this.presidente = presidente; }
    public String getSecretario() { return secretario; }
    public void setSecretario(String secretario) { this.secretario = secretario; }
    public String getTesorero() { return tesorero; }
    public void setTesorero(String tesorero) { this.tesorero = tesorero; }
    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }
    public int getNumPresidentes() { return numPresidentes; }
    public void setNumPresidentes(int numPresidentes) { this.numPresidentes = numPresidentes; }
    public int getNumGobernadores() { return numGobernadores; }
    public void setNumGobernadores(int numGobernadores) { this.numGobernadores = numGobernadores; }
    public int getNumAlcaldes() { return numAlcaldes; }
    public void setNumAlcaldes(int numAlcaldes) { this.numAlcaldes = numAlcaldes; }
    public int getNumConcejales() { return numConcejales; }
    public void setNumConcejales(int numConcejales) { this.numConcejales = numConcejales; }
    public int getNumCongresistas() { return numCongresistas; }
    public void setNumCongresistas(int numCongresistas) { this.numCongresistas = numCongresistas; }
    public java.time.LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(java.time.LocalDateTime createdAt) { this.createdAt = createdAt; }
    public java.time.LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(java.time.LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}