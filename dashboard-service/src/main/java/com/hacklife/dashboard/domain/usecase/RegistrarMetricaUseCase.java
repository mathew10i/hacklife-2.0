package com.hacklife.dashboard.domain.usecase;

import com.hacklife.dashboard.domain.model.Metrica;

import java.util.UUID;

public interface RegistrarMetricaUseCase {

    Metrica registrar(UUID usuarioId, String nombre, double valor);
}
