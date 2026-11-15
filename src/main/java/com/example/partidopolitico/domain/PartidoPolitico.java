package com.example.partidopolitico.domain;

import java.time.LocalDateTime;
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
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    private PartidoPolitico(PartidoPoliticoBuilder builder) {
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

    public PartidoPoliticoId id() {
        return id;
    }

    public PartidoPoliticoNombre nombre() {
        return nombre;
    }

    public PartidoPoliticoEslogan eslogan() {
        return eslogan;
    }

    public String presidente() {
        return presidente;
    }

    public String secretario() {
        return secretario;
    }

    public String tesorero() {
        return tesorero;
    }

    public String pais() {
        return pais;
    }

    public int numPresidentes() {
        return numPresidentes;
    }

    public int numGobernadores() {
        return numGobernadores;
    }

    public int numAlcaldes() {
        return numAlcaldes;
    }

    public int numConcejales() {
        return numConcejales;
    }

    public int numCongresistas() {
        return numCongresistas;
    }

    public boolean activo() {
        return activo;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public LocalDateTime updatedAt() {
        return updatedAt;
    }

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

        return new PartidoPoliticoBuilder()
                .id(this.id)
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
                .activo(this.activo)
                .createdAt(this.createdAt)
                .updatedAt(LocalDateTime.now())
                .build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartidoPolitico that = (PartidoPolitico) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
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

    public static final class PartidoPoliticoBuilder {

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
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public PartidoPoliticoBuilder() {
            this.activo = true;
            this.createdAt = LocalDateTime.now();
            this.updatedAt = LocalDateTime.now();
        }

        public PartidoPoliticoBuilder id(PartidoPoliticoId id) {
            this.id = id;
            return this;
        }

        public PartidoPoliticoBuilder nombre(PartidoPoliticoNombre nombre) {
            this.nombre = nombre;
            return this;
        }

        public PartidoPoliticoBuilder eslogan(PartidoPoliticoEslogan eslogan) {
            this.eslogan = eslogan;
            return this;
        }

        public PartidoPoliticoBuilder presidente(String presidente) {
            this.presidente = presidente;
            return this;
        }

        public PartidoPoliticoBuilder secretario(String secretario) {
            this.secretario = secretario;
            return this;
        }

        public PartidoPoliticoBuilder tesorero(String tesorero) {
            this.tesorero = tesorero;
            return this;
        }

        public PartidoPoliticoBuilder pais(String pais) {
            this.pais = pais;
            return this;
        }

        public PartidoPoliticoBuilder numPresidentes(int numPresidentes) {
            this.numPresidentes = numPresidentes;
            return this;
        }

        public PartidoPoliticoBuilder numGobernadores(int numGobernadores) {
            this.numGobernadores = numGobernadores;
            return this;
        }

        public PartidoPoliticoBuilder numAlcaldes(int numAlcaldes) {
            this.numAlcaldes = numAlcaldes;
            return this;
        }

        public PartidoPoliticoBuilder numConcejales(int numConcejales) {
            this.numConcejales = numConcejales;
            return this;
        }

        public PartidoPoliticoBuilder numCongresistas(int numCongresistas) {
            this.numCongresistas = numCongresistas;
            return this;
        }

        public PartidoPoliticoBuilder activo(boolean activo) {
            this.activo = activo;
            return this;
        }

        public PartidoPoliticoBuilder createdAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public PartidoPoliticoBuilder updatedAt(LocalDateTime updatedAt) {
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
            if (presidente == null || presidente.isBlank()) {
                throw new IllegalStateException("El presidente es obligatorio");
            }
            if (secretario == null || secretario.isBlank()) {
                throw new IllegalStateException("El secretario es obligatorio");
            }
            if (tesorero == null || tesorero.isBlank()) {
                throw new IllegalStateException("El tesorero es obligatorio");
            }
            if (numPresidentes < 0 || numGobernadores < 0 || numAlcaldes < 0
                    || numConcejales < 0 || numCongresistas < 0) {
                throw new IllegalStateException("Los conteos no pueden ser negativos");
            }
        }
    }
}