package com.hacklife.habitstreak.infrastructure.driver_adapter;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HabitoDataJpaRepository extends JpaRepository<HabitoData, UUID> {
}
