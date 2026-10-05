package com.hacklife.habitstreak.infrastructure.rest;

import com.hacklife.habitstreak.domain.model.Habit;
import com.hacklife.habitstreak.domain.model.HabitFrequency;

import java.time.Instant;
import java.util.UUID;

public record CreateHabitResponse(
        UUID id,
        UUID userId,
        String name,
        HabitFrequency frequency,
        Instant createdAt
) {

    public static CreateHabitResponse from(Habit habit) {
        return new CreateHabitResponse(
                habit.id().value(),
                habit.userId().value(),
                habit.name(),
                habit.frequency(),
                habit.createdAt()
        );
    }
}
