package com.hacklife.dashboard.infrastructure.entry_points;

import com.hacklife.dashboard.domain.model.Metrica;

import java.time.Instant;
import java.util.UUID;

public record MetricaResponse(UUID id, UUID usuarioId, String nombre, double valor, Instant registradaEn) {

    public static MetricaResponse from(Metrica metrica) {
        return new MetricaResponse(
                metrica.id(),
                metrica.usuarioId(),
                metrica.nombre(),
                metrica.valor(),
                metrica.registradaEn()
        );
    }
}
