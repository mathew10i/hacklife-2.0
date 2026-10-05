package com.hacklife.goalprogress.domain.usecase;

import com.hacklife.goalprogress.domain.model.Objetivo;

import java.util.UUID;

public interface CrearObjetivoUseCase {

    Objetivo crear(UUID usuarioId, String titulo, int meta);
}
