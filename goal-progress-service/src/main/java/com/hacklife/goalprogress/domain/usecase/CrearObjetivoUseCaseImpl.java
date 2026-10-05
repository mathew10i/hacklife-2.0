package com.hacklife.goalprogress.domain.usecase;

import com.hacklife.goalprogress.domain.model.Objetivo;
import com.hacklife.goalprogress.domain.model.gateway.ObjetivoGateway;

import java.time.Clock;
import java.util.Objects;
import java.util.UUID;

public class CrearObjetivoUseCaseImpl implements CrearObjetivoUseCase {

    private final ObjetivoGateway objetivoGateway;
    private final Clock clock;

    public CrearObjetivoUseCaseImpl(ObjetivoGateway objetivoGateway, Clock clock) {
        this.objetivoGateway = Objects.requireNonNull(objetivoGateway, "ObjetivoGateway es obligatorio");
        this.clock = Objects.requireNonNull(clock, "Clock es obligatorio");
    }

    @Override
    public Objetivo crear(UUID usuarioId, String titulo, int meta) {
        Objetivo objetivo = Objetivo.crearNuevo(usuarioId, titulo, meta, clock);
        return objetivoGateway.guardar(objetivo);
    }
}
