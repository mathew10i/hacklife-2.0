package com.hacklife.gamification.domain.usecase;

import com.hacklife.gamification.domain.model.Puntos;
import com.hacklife.gamification.domain.model.gateway.PuntosGateway;

import java.time.Clock;
import java.util.Objects;
import java.util.UUID;

public class AsignarPuntosUseCaseImpl implements AsignarPuntosUseCase {

    private final PuntosGateway puntosGateway;
    private final Clock clock;

    public AsignarPuntosUseCaseImpl(PuntosGateway puntosGateway, Clock clock) {
        this.puntosGateway = Objects.requireNonNull(puntosGateway, "PuntosGateway es obligatorio");
        this.clock = Objects.requireNonNull(clock, "Clock es obligatorio");
    }

    @Override
    public Puntos asignar(UUID usuarioId, int valor, String motivo) {
        Puntos puntos = Puntos.asignar(usuarioId, valor, motivo, clock);
        return puntosGateway.guardar(puntos);
    }
}
