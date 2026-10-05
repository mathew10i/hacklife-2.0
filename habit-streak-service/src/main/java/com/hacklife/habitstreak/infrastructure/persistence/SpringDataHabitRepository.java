package com.hacklife.habitstreak.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpringDataHabitRepository extends JpaRepository<HabitJpaEntity, UUID> {
}
