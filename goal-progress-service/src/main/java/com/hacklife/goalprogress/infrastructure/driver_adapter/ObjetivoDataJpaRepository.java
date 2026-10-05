package com.hacklife.goalprogress.infrastructure.driver_adapter;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ObjetivoDataJpaRepository extends JpaRepository<ObjetivoData, UUID> {
}
