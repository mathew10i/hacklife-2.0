package com.hacklife.habitstreak.infrastructure.rest;

import com.hacklife.habitstreak.domain.model.HabitFrequency;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record CreateHabitRequest(
        @NotNull UUID userId,
        @NotBlank String name,
        @NotNull HabitFrequency frequency
) {
}
