package com.hacklife.notification.domain.usecase;

import com.hacklife.notification.domain.model.Notificacion;

import java.util.UUID;

public interface CrearNotificacionUseCase {

    Notificacion crear(UUID usuarioId, String mensaje);
}
