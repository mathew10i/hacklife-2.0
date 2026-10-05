package com.hacklife.notification.domain.usecase;

import com.hacklife.notification.domain.model.Notificacion;
import com.hacklife.notification.domain.model.gateway.NotificacionGateway;

import java.time.Clock;
import java.util.Objects;
import java.util.UUID;

public class CrearNotificacionUseCaseImpl implements CrearNotificacionUseCase {

    private final NotificacionGateway notificacionGateway;
    private final Clock clock;

    public CrearNotificacionUseCaseImpl(NotificacionGateway notificacionGateway, Clock clock) {
        this.notificacionGateway = Objects.requireNonNull(notificacionGateway, "NotificacionGateway es obligatorio");
        this.clock = Objects.requireNonNull(clock, "Clock es obligatorio");
    }

    @Override
    public Notificacion crear(UUID usuarioId, String mensaje) {
        Notificacion notificacion = Notificacion.crearNueva(usuarioId, mensaje, clock);
        return notificacionGateway.guardar(notificacion);
    }
}
