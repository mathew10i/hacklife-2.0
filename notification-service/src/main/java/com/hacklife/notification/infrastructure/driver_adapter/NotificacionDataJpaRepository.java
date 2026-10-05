package com.hacklife.notification.infrastructure.driver_adapter;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NotificacionDataJpaRepository extends JpaRepository<NotificacionData, UUID> {
}
