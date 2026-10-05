package com.hacklife.authuser.domain.model;

import java.time.Clock;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public record Usuario(UUID id, String correo, String nombre, Instant creadoEn) {

    public Usuario {
        Objects.requireNonNull(id, "El id es obligatorio");
        if (correo == null || correo.isBlank()) {
            throw new IllegalArgumentException("El correo es obligatorio");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        Objects.requireNonNull(creadoEn, "La fecha de creación es obligatoria");
        correo = correo.trim();
        nombre = nombre.trim();
    }

    public static Usuario crearNuevo(String correo, String nombre, Clock clock) {
        Objects.requireNonNull(clock, "Clock es obligatorio");
        return new Usuario(UUID.randomUUID(), correo, nombre, Instant.now(clock));
    }
}
