package com.example.partidopolitico.domain;

import java.util.Objects;

public final class PartidoPolitico {

    private final PartidoPoliticoId id;
    private final PartidoPoliticoNombre nombre;
    private final PartidoPoliticoEslogan eslogan;
    private final String presidente;
    private final String secretario;
    private final String tesorero;
    private final String pais;
    private final int numPresidentes;
    private final int numGobernadores;
    private final int numAlcaldes;
    private final int numConcejales;
    private final int numCongresistas;
    private final boolean activo;
    private final java.time.LocalDateTime createdAt;
    private java.time.LocalDateTime updatedAt;

    private PartidoPolitico(Builder builder) {
        this.id = builder.id;
        this.nombre = builder.nombre;
        this.eslogan = builder.eslogan;
        this.presidente = builder.presidente;
        this.secretario = builder.secretario;
        this.tesorero = builder.tesorero;
        this.pais = builder.pais;
        this.numPresidentes = builder.numPresidentes;
        this.numGobernadores = builder.numGobernadores;
        this.numAlcaldes = builder.numAlcaldes;
        this.numConcejales = builder.numConcejales;
        this.numCongresistas = builder.numCongresistas;
        this.activo = builder.activo;
        this.createdAt = builder.createdAt;
        this.updatedAt = builder.updatedAt;
    }

    public PartidoPoliticoId id() { return id; }
    public PartidoPoliticoNombre nombre() { return nombre; }
    public PartidoPoliticoEslogan eslogan() { return eslogan; }
    public String presidente() { return presidente; }
    public String secretario() { return secretario; }
    public String tesorero() { return tesorero; }
    public String pais() { return pais; }
    public int numPresidentes() { return numPresidentes; }
    public int numGobernadores() { return numGobernadores; }
    public int numAlcaldes() { return numAlcaldes; }
    public int numConcejales() { return numConcejales; }
    public int numCongresistas() { return numCongresistas; }
    public boolean activo() { return activo; }
    public java.time.LocalDateTime createdAt() { return createdAt; }
    public java.time.LocalDateTime updatedAt() { return updatedAt; }

    public PartidoPolitico actualizar(
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
            int numCongresistas) {

        PartidoPolitico actualizado = new PartidoPolitico(new Builder(this));
        actualizado.nombre = PartidoPoliticoNombre.of(nombre);
        actualizado.eslogan = PartidoPoliticoEslogan.of(eslogan);
        actualizado.presidente = presidente;
        actualizado.secretario = secretario;
        actualizado.tesorero = tesorero;
        actualizado.pais = pais;
        actualizado.numPresidentes = numPresidentes;
        actualizado.numGobernadores = numGobernadores;
        actualizado.numAlcaldes = numAlcaldes;
        actualizado.numConcejales = numConcejales;
        actualizado.numCongresistas = numCongresistas;
        actualizado.updatedAt = java.time.LocalDateTime.now();
        return actualizado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartidoPolitico that = (PartidoPolitico) o;
        return numPresidentes == that.numPresidentes &&
               numGobernadores == that.numGobernadores &&
               numAlcaldes == that.numAlcaldes &&
               numConcejales == that.numConcejales &&
               numCongresistas == that.numCongresistas &&
               Objects.equals(id, that.id) &&
               Objects.equals(nombre, that.nombre) &&
               Objects.equals(eslogan, that.eslogan) &&
               Objects.equals(presidente, that.presidente) &&
               Objects.equals(secretario, that.secretario) &&
               Objects.equals(tesorero, that.tesorero) &&
               Objects.equals(pais, that.pais) &&
               activo == that.activo &&
               Objects.equals(createdAt, that.createdAt) &&
               Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, eslogan, presidente, secretario, tesorero, pais,
            numPresidentes, numGobernadores, numAlcaldes, numConcejales, numCongresistas, activo, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "PartidoPolitico{" +
                "id=" + id +
                ", nombre=" + nombre +
                ", eslogan=" + eslogan +
                ", presidente=" + presidente +
                ", secretario=" + secretario +
                ", tesorero=" + tesorero +
                ", pais=" + pais +
                ", numPresidentes=" + numPresidentes +
                ", numGobernadores=" + numGobernadores +
                ", numAlcaldes=" + numAlcaldes +
                ", numConcejales=" + numConcejales +
                ", numCongresistas=" + numCongresistas +
                ", activo=" + activo +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public static final class Builder {
        private PartidoPoliticoId id;
        private PartidoPoliticoNombre nombre;
        private PartidoPoliticoEslogan eslogan;
        private String presidente;
        private String secretario;
        private String tesorero;
        private String pais;
        private int numPresidentes;
        private int numGobernadores;
        private int numAlcaldes;
        private int numConcejales;
        private int numCongresistas;
        private boolean activo;
        private java.time.LocalDateTime createdAt;
        private java.time.LocalDateTime updatedAt;

        public Builder() {
            this.activo = true;
            this.createdAt = java.time.LocalDateTime.now();
        }

        private Builder(PartidoPolitico partidoPolitico) {
            this.id = partidoPolitico.id;
            this.nombre = partidoPolitico.nombre;
            this.eslogan = partidoPolitico.eslogan;
            this.presidente = partidoPolitico.presidente;
            this.secretario = partidoPolitico.secretario;
            this.tesorero = partidoPolitico.tesorero;
            this.pais = partidoPolitico.pais;
            this.numPresidentes = partidoPolitico.numPresidentes;
            this.numGobernadores = partidoPolitico.numGobernadores;
            this.numAlcaldes = partidoPolitico.numAlcaldes;
            this.numConcejales = partidoPolitico.numConcejales;
            this.numCongresistas = partidoPolitico.numCongresistas;
            this.activo = partidoPolitico.activo;
            this.createdAt = partidoPolitico.createdAt;
            this.updatedAt = partidoPolitico.updatedAt;
        }

        public Builder id(PartidoPoliticoId id) {
            this.id = id;
            return this;
        }

        public Builder nombre(PartidoPoliticoNombre nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder eslogan(PartidoPoliticoEslogan eslogan) {
            this.eslogan = eslogan;
            return this;
        }

        public Builder presidente(String presidente) {
            this.presidente = presidente;
            return this;
        }

        public Builder secretario(String secretario) {
            this.secretario = secretario;
            return this;
        }

        public Builder tesorero(String tesorero) {
            this.tesorero = tesorero;
            return this;
        }

        public Builder pais(String pais) {
            this.pais = pais;
            return this;
        }

        public Builder numPresidentes(int numPresidentes) {
            this.numPresidentes = numPresidentes;
            return this;
        }

        public Builder numGobernadores(int numGobernadores) {
            this.numGobernadores = numGobernadores;
            return this;
        }

        public Builder numAlcaldes(int numAlcaldes) {
            this.numAlcaldes = numAlcaldes;
            return this;
        }

        public Builder numConcejales(int numConcejales) {
            this.numConcejales = numConcejales;
            return this;
        }

        public Builder numCongresistas(int numCongresistas) {
            this.numCongresistas = numCongresistas;
            return this;
        }

        public Builder activo(boolean activo) {
            this.activo = activo;
            return this;
        }

        public Builder createdAt(java.time.LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder updatedAt(java.time.LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public PartidoPolitico build() {
            validate();
            return new PartidoPolitico(this);
        }

        private void validate() {
            if (id == null) {
                throw new IllegalStateException("El ID es obligatorio");
            }
            if (nombre == null) {
                throw new IllegalStateException("El nombre es obligatorio");
            }
            if (eslogan == null) {
                throw new IllegalStateException("El eslogan es obligatorio");
            }
            if (pais == null || pais.isBlank()) {
                throw new IllegalStateException("El país es obligatorio");
            }
        }
    }
}