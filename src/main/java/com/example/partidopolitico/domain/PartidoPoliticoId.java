package com.example.partidopolitico.domain;

import java.util.Objects;
import java.util.UUID;

public final class PartidoPoliticoId {

    private final String value;

    private PartidoPoliticoId(String value) {
        this.value = value;
    }

    public static PartidoPoliticoId of(String id) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("El ID de un PartidoPolítico no puede ser nulo o vacío");
        }
        try {
            UUID.fromString(id);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException(
                    "El ID '" + id + "' no es un UUID válido. Formato esperado: 8-4-4-4-12 (ej: b3b8cd37-9634-4eaa-9861-a7c7e47a76da)");
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