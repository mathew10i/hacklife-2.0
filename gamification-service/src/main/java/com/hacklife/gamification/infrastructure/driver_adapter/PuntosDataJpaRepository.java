package com.hacklife.gamification.infrastructure.driver_adapter;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PuntosDataJpaRepository extends JpaRepository<PuntosData, UUID> {
}
