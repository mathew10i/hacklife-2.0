package com.hacklife.goalprogress.infrastructure.entry_points;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public record CrearObjetivoRequest(
        @NotNull UUID usuarioId,
        @NotBlank String titulo,
        @Positive int meta
) {
}
