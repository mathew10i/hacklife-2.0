package com.hacklife.notification.domain.model;

import java.time.Clock;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public record Notificacion(UUID id, UUID usuarioId, String mensaje, Instant creadaEn) {

    public Notificacion {
        Objects.requireNonNull(id, "El id es obligatorio");
        Objects.requireNonNull(usuarioId, "El usuarioId es obligatorio");
        if (mensaje == null || mensaje.isBlank()) {
            throw new IllegalArgumentException("El mensaje es obligatorio");
        }
        Objects.requireNonNull(creadaEn, "La fecha de creación es obligatoria");
        mensaje = mensaje.trim();
    }

    public static Notificacion crearNueva(UUID usuarioId, String mensaje, Clock clock) {
        Objects.requireNonNull(clock, "Clock es obligatorio");
        return new Notificacion(UUID.randomUUID(), usuarioId, mensaje, Instant.now(clock));
    }
}
