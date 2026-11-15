package com.example.partidopolitico.domain;

import java.util.Objects;

public final class PartidoPoliticoNombre {

    private final String value;

    private PartidoPoliticoNombre(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("El nombre de un PartidoPolítico no puede ser nulo o vacío");
        }
        if (value.length() > 120) {
            throw new IllegalArgumentException("El nombre de un PartidoPolítico no puede tener más de 120 caracteres");
        }
        this.value = value;
    }

    public static PartidoPoliticoNombre of(String nombre) {
        return new PartidoPoliticoNombre(nombre);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartidoPoliticoNombre that = (PartidoPoliticoNombre) o;
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