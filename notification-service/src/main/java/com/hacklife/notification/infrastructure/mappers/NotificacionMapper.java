package com.hacklife.notification.infrastructure.mappers;

import com.hacklife.notification.domain.model.Notificacion;
import com.hacklife.notification.infrastructure.driver_adapter.NotificacionData;
import org.springframework.stereotype.Component;

@Component
public class NotificacionMapper {

    public NotificacionData toData(Notificacion notificacion) {
        return new NotificacionData(
                notificacion.id(),
                notificacion.usuarioId(),
                notificacion.mensaje(),
                notificacion.creadaEn()
        );
    }

    public Notificacion toDomain(NotificacionData data) {
        return new Notificacion(data.getId(), data.getUsuarioId(), data.getMensaje(), data.getCreadaEn());
    }
}
