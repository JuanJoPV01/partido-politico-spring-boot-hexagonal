package com.example.partidopolitico.domain;

import java.util.Objects;

public final class PartidoPoliticoEslogan {

    private final String value;

    private PartidoPoliticoEslogan(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("El eslogan de un PartidoPolítico no puede ser nulo o vacío");
        }
        if (value.length() > 180) {
            throw new IllegalArgumentException("El eslogan de un PartidoPolítico no puede tener más de 180 caracteres");
        }
        this.value = value;
    }

    public static PartidoPoliticoEslogan of(String eslogan) {
        return new PartidoPoliticoEslogan(eslogan);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartidoPoliticoEslogan that = (PartidoPoliticoEslogan) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value;
    }
}