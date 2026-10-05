package com.hacklife.habitstreak.application.command;

import com.hacklife.habitstreak.domain.model.HabitFrequency;

import java.util.UUID;

public record CreateHabitCommand(
        UUID userId,
        String name,
        HabitFrequency frequency
) {
}
