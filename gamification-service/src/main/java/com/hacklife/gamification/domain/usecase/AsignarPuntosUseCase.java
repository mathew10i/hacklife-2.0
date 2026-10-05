package com.hacklife.gamification.domain.usecase;

import com.hacklife.gamification.domain.model.Puntos;

import java.util.UUID;

public interface AsignarPuntosUseCase {

    Puntos asignar(UUID usuarioId, int valor, String motivo);
}
