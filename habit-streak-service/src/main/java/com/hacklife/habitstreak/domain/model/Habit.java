package com.hacklife.habitstreak.domain.model;

import java.time.Clock;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public final class Habit {

    private final HabitId id;
    private final UserId userId;
    private final String name;
    private final HabitFrequency frequency;
    private final Instant createdAt;

    public Habit(HabitId id, UserId userId, String name, HabitFrequency frequency, Instant createdAt) {
        this.id = Objects.requireNonNull(id, "HabitId es obligatorio");
        this.userId = Objects.requireNonNull(userId, "UserId es obligatorio");
        this.frequency = Objects.requireNonNull(frequency, "La frecuencia es obligatoria");
        this.createdAt = Objects.requireNonNull(createdAt, "La fecha de creación es obligatoria");
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("El nombre del hábito es obligatorio");
        }
        this.name = name.trim();
    }

    public static Habit createNew(UserId userId, String name, HabitFrequency frequency, Clock clock) {
        Objects.requireNonNull(clock, "Clock es obligatorio");
        return new Habit(new HabitId(UUID.randomUUID()), userId, name, frequency, Instant.now(clock));
    }

    public HabitId id() {
        return id;
    }

    public UserId userId() {
        return userId;
    }

    public String name() {
        return name;
    }

    public HabitFrequency frequency() {
        return frequency;
    }

    public Instant createdAt() {
        return createdAt;
    }
}
