package com.hacklife.dashboard.infrastructure.driver_adapter;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MetricaDataJpaRepository extends JpaRepository<MetricaData, UUID> {
}
