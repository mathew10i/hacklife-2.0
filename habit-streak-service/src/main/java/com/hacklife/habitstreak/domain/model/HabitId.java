package com.hacklife.habitstreak.domain.model;

import java.util.UUID;

public record HabitId(UUID value) {

    public HabitId {
        if (value == null) {
            throw new IllegalArgumentException("HabitId no puede ser nulo");
        }
    }
}
