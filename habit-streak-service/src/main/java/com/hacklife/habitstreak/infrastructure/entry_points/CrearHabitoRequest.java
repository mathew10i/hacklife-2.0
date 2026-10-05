package com.hacklife.habitstreak.infrastructure.entry_points;

import com.hacklife.habitstreak.domain.model.FrecuenciaHabito;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CrearHabitoRequest(
        @NotNull UUID usuarioId,
        @NotBlank String nombre,
        @NotNull FrecuenciaHabito frecuencia
) {
}
