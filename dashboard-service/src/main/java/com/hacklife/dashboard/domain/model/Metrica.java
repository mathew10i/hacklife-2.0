package com.hacklife.dashboard.domain.model;

import java.time.Clock;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public record Metrica(UUID id, UUID usuarioId, String nombre, double valor, Instant registradaEn) {

    public Metrica {
        Objects.requireNonNull(id, "El id es obligatorio");
        Objects.requireNonNull(usuarioId, "El usuarioId es obligatorio");
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        Objects.requireNonNull(registradaEn, "La fecha de registro es obligatoria");
        nombre = nombre.trim();
    }

    public static Metrica registrar(UUID usuarioId, String nombre, double valor, Clock clock) {
        Objects.requireNonNull(clock, "Clock es obligatorio");
        return new Metrica(UUID.randomUUID(), usuarioId, nombre, valor, Instant.now(clock));
    }
}
