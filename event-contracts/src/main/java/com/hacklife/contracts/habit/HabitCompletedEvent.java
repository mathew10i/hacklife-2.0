package com.hacklife.contracts.habit;

import java.time.Instant;
import java.util.UUID;

public record HabitCompletedEvent(
        String eventVersion,
        UUID habitId,
        UUID userId,
        Instant completedAt,
        Instant occurredAt
) {
}
