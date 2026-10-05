package com.hacklife.habitstreak.infrastructure.persistence;

import com.hacklife.habitstreak.domain.model.HabitFrequency;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "habits")
public class HabitJpaEntity {

    @Id
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private HabitFrequency frequency;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    protected HabitJpaEntity() {
    }

    public HabitJpaEntity(UUID id, UUID userId, String name, HabitFrequency frequency, Instant createdAt) {
        this.id = id;
        this.userId = userId;
        this.name = name;
        this.frequency = frequency;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public HabitFrequency getFrequency() {
        return frequency;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
