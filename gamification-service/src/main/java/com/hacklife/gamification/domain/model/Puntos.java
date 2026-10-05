package com.hacklife.gamification.domain.model;

import java.time.Clock;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public record Puntos(UUID id, UUID usuarioId, int valor, String motivo, Instant asignadoEn) {

    public Puntos {
        Objects.requireNonNull(id, "El id es obligatorio");
        Objects.requireNonNull(usuarioId, "El usuarioId es obligatorio");
        if (valor <= 0) {
            throw new IllegalArgumentException("El valor de puntos debe ser mayor a cero");
        }
        if (motivo == null || motivo.isBlank()) {
            throw new IllegalArgumentException("El motivo es obligatorio");
        }
        Objects.requireNonNull(asignadoEn, "La fecha de asignación es obligatoria");
        motivo = motivo.trim();
    }

    public static Puntos asignar(UUID usuarioId, int valor, String motivo, Clock clock) {
        Objects.requireNonNull(clock, "Clock es obligatorio");
        return new Puntos(UUID.randomUUID(), usuarioId, valor, motivo, Instant.now(clock));
    }
}
