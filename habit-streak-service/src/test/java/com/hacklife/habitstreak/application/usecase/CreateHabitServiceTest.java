package com.hacklife.habitstreak.application.usecase;

import com.hacklife.habitstreak.application.command.CreateHabitCommand;
import com.hacklife.habitstreak.application.port.out.HabitRepositoryPort;
import com.hacklife.habitstreak.domain.model.Habit;
import com.hacklife.habitstreak.domain.model.HabitFrequency;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CreateHabitServiceTest {

    @Test
    void shouldCreateAndPersistHabit() {
        Clock fixedClock = Clock.fixed(Instant.parse("2026-01-01T10:00:00Z"), ZoneOffset.UTC);
        CapturingHabitRepository repository = new CapturingHabitRepository();
        CreateHabitService service = new CreateHabitService(repository, fixedClock);

        Habit created = service.create(new CreateHabitCommand(
                UUID.fromString("22222222-2222-2222-2222-222222222222"),
                "Leer 20 minutos",
                HabitFrequency.DAILY
        ));

        assertEquals("Leer 20 minutos", created.name());
        assertEquals(HabitFrequency.DAILY, created.frequency());
        assertEquals(Instant.parse("2026-01-01T10:00:00Z"), created.createdAt());
        assertEquals(created, repository.savedHabit);
    }

    private static final class CapturingHabitRepository implements HabitRepositoryPort {
        private Habit savedHabit;

        @Override
        public Habit save(Habit habit) {
            this.savedHabit = habit;
            return habit;
        }
    }
}
