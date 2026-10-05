package com.hacklife.habitstreak.domain.usecase;

import com.hacklife.habitstreak.domain.model.FrecuenciaHabito;
import com.hacklife.habitstreak.domain.model.Habito;
import com.hacklife.habitstreak.domain.model.gateway.HabitoGateway;

import java.time.Clock;
import java.util.Objects;
import java.util.UUID;

public class CrearHabitoUseCaseImpl implements CrearHabitoUseCase {

    private final HabitoGateway habitoGateway;
    private final Clock clock;

    public CrearHabitoUseCaseImpl(HabitoGateway habitoGateway, Clock clock) {
        this.habitoGateway = Objects.requireNonNull(habitoGateway, "HabitoGateway es obligatorio");
        this.clock = Objects.requireNonNull(clock, "Clock es obligatorio");
    }

    @Override
    public Habito crear(UUID usuarioId, String nombre, FrecuenciaHabito frecuencia) {
        Habito habito = Habito.crearNuevo(usuarioId, nombre, frecuencia, clock);
        return habitoGateway.guardar(habito);
    }
}
