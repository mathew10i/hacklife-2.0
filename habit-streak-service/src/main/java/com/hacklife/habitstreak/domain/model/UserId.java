package com.hacklife.habitstreak.domain.model;

import java.util.UUID;

public record UserId(UUID value) {

    public UserId {
        if (value == null) {
            throw new IllegalArgumentException("UserId no puede ser nulo");
        }
    }
}
