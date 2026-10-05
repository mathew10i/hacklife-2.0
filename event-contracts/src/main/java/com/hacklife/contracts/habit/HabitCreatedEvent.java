package com.hacklife.contracts.habit;

import java.time.Instant;
import java.util.UUID;

public record HabitCreatedEvent(
        String eventVersion,
        UUID habitId,
        UUID userId,
        String habitName,
        String frequency,
        Instant occurredAt
) {
}
