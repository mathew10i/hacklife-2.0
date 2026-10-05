package com.hacklife.notification.application;

import com.hacklife.notification.domain.model.gateway.NotificacionGateway;
import com.hacklife.notification.domain.usecase.CrearNotificacionUseCase;
import com.hacklife.notification.domain.usecase.CrearNotificacionUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class NotificationConfig {

    @Bean
    public Clock notificationClock() {
        return Clock.systemUTC();
    }

    @Bean
    public CrearNotificacionUseCase crearNotificacionUseCase(NotificacionGateway notificacionGateway, Clock notificationClock) {
        return new CrearNotificacionUseCaseImpl(notificacionGateway, notificationClock);
    }
}
