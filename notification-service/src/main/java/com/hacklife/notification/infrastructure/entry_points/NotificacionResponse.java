package com.hacklife.notification.infrastructure.entry_points;

import com.hacklife.notification.domain.model.Notificacion;

import java.time.Instant;
import java.util.UUID;

public record NotificacionResponse(UUID id, UUID usuarioId, String mensaje, Instant creadaEn) {

    public static NotificacionResponse from(Notificacion notificacion) {
        return new NotificacionResponse(
                notificacion.id(),
                notificacion.usuarioId(),
                notificacion.mensaje(),
                notificacion.creadaEn()
        );
    }
}
