package com.hacklife.habitstreak.domain.usecase;

import com.hacklife.habitstreak.domain.model.FrecuenciaHabito;
import com.hacklife.habitstreak.domain.model.Habito;

import java.util.UUID;

public interface CrearHabitoUseCase {

    Habito crear(UUID usuarioId, String nombre, FrecuenciaHabito frecuencia);
}
