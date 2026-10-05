package com.hacklife.habitstreak.infrastructure.entry_points;

import com.hacklife.habitstreak.domain.model.FrecuenciaHabito;
import com.hacklife.habitstreak.domain.model.Habito;

import java.time.Instant;
import java.util.UUID;

public record HabitoResponse(UUID id, UUID usuarioId, String nombre, FrecuenciaHabito frecuencia, Instant creadoEn) {

    public static HabitoResponse from(Habito habito) {
        return new HabitoResponse(habito.id(), habito.usuarioId(), habito.nombre(), habito.frecuencia(), habito.creadoEn());
    }
}
