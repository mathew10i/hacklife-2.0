package com.hacklife.notification.infrastructure.entry_points;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CrearNotificacionRequest(
        @NotNull UUID usuarioId,
        @NotBlank String mensaje
) {
}
