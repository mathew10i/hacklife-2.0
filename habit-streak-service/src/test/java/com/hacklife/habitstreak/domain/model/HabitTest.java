package com.hacklife.habitstreak.domain.model;

import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HabitTest {

    @Test
    void shouldCreateHabitWithValidValues() {
        Clock fixedClock = Clock.fixed(Instant.parse("2026-01-01T10:00:00Z"), ZoneOffset.UTC);

        Habit habit = Habit.createNew(new UserId(UUID.fromString("11111111-1111-1111-1111-111111111111")), "Tomar agua", HabitFrequency.DAILY, fixedClock);

        assertEquals("Tomar agua", habit.name());
        assertEquals(HabitFrequency.DAILY, habit.frequency());
        assertEquals(Instant.parse("2026-01-01T10:00:00Z"), habit.createdAt());
    }

    @Test
    void shouldRejectBlankName() {
        assertThrows(IllegalArgumentException.class, () -> new Habit(
                new HabitId(UUID.randomUUID()),
                new UserId(UUID.randomUUID()),
                "  ",
                HabitFrequency.WEEKLY,
                Instant.now()
        ));
    }
}
