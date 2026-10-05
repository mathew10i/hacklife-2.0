package com.hacklife.gamification.infrastructure.entry_points;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public record AsignarPuntosRequest(
        @NotNull UUID usuarioId,
        @Positive int valor,
        @NotBlank String motivo
) {
}
