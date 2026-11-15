package com.example.partidopolitico.domain;

import java.util.Objects;

public final class PartidoPoliticoId {

    private final String value;

    private PartidoPoliticoId(String value) {
        this.value = value;
    }

    public static PartidoPoliticoId of(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El ID de un PartidoPolítico no puede ser nulo o vacío");
        }
        return new PartidoPoliticoId(id);
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartidoPoliticoId that = (PartidoPoliticoId) o;
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