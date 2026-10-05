package com.hacklife.habitstreak.domain.model;

import java.time.Clock;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public record Habito(UUID id, UUID usuarioId, String nombre, FrecuenciaHabito frecuencia, Instant creadoEn) {

    public Habito {
        Objects.requireNonNull(id, "El id es obligatorio");
        Objects.requireNonNull(usuarioId, "El usuarioId es obligatorio");
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre del hábito es obligatorio");
        }
        Objects.requireNonNull(frecuencia, "La frecuencia es obligatoria");
        Objects.requireNonNull(creadoEn, "La fecha de creación es obligatoria");
        nombre = nombre.trim();
    }

    public static Habito crearNuevo(UUID usuarioId, String nombre, FrecuenciaHabito frecuencia, Clock clock) {
        Objects.requireNonNull(clock, "Clock es obligatorio");
        return new Habito(UUID.randomUUID(), usuarioId, nombre, frecuencia, Instant.now(clock));
    }
}
