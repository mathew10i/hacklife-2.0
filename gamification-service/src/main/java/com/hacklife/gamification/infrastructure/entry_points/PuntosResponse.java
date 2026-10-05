package com.hacklife.gamification.infrastructure.entry_points;

import com.hacklife.gamification.domain.model.Puntos;

import java.time.Instant;
import java.util.UUID;

public record PuntosResponse(UUID id, UUID usuarioId, int valor, String motivo, Instant asignadoEn) {

    public static PuntosResponse from(Puntos puntos) {
        return new PuntosResponse(puntos.id(), puntos.usuarioId(), puntos.valor(), puntos.motivo(), puntos.asignadoEn());
    }
}
