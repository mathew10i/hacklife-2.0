package com.hacklife.goalprogress.domain.model;

import java.time.Clock;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public record Objetivo(UUID id, UUID usuarioId, String titulo, int meta, Instant creadoEn) {

    public Objetivo {
        Objects.requireNonNull(id, "El id es obligatorio");
        Objects.requireNonNull(usuarioId, "El usuarioId es obligatorio");
        if (titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("El título es obligatorio");
        }
        if (meta <= 0) {
            throw new IllegalArgumentException("La meta debe ser mayor a cero");
        }
        Objects.requireNonNull(creadoEn, "La fecha de creación es obligatoria");
        titulo = titulo.trim();
    }

    public static Objetivo crearNuevo(UUID usuarioId, String titulo, int meta, Clock clock) {
        Objects.requireNonNull(clock, "Clock es obligatorio");
        return new Objetivo(UUID.randomUUID(), usuarioId, titulo, meta, Instant.now(clock));
    }
}
