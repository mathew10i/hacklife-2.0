package com.hacklife.goalprogress.infrastructure.entry_points;

import com.hacklife.goalprogress.domain.model.Objetivo;

import java.time.Instant;
import java.util.UUID;

public record ObjetivoResponse(UUID id, UUID usuarioId, String titulo, int meta, Instant creadoEn) {

    public static ObjetivoResponse from(Objetivo objetivo) {
        return new ObjetivoResponse(objetivo.id(), objetivo.usuarioId(), objetivo.titulo(), objetivo.meta(), objetivo.creadoEn());
    }
}
