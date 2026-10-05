package com.hacklife.dashboard.infrastructure.entry_points;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record RegistrarMetricaRequest(
        @NotNull UUID usuarioId,
        @NotBlank String nombre,
        double valor
) {
}
