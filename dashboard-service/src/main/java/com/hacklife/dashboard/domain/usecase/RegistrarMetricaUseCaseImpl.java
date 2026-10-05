package com.hacklife.dashboard.domain.usecase;

import com.hacklife.dashboard.domain.model.Metrica;
import com.hacklife.dashboard.domain.model.gateway.MetricaGateway;

import java.time.Clock;
import java.util.Objects;
import java.util.UUID;

public class RegistrarMetricaUseCaseImpl implements RegistrarMetricaUseCase {

    private final MetricaGateway metricaGateway;
    private final Clock clock;

    public RegistrarMetricaUseCaseImpl(MetricaGateway metricaGateway, Clock clock) {
        this.metricaGateway = Objects.requireNonNull(metricaGateway, "MetricaGateway es obligatorio");
        this.clock = Objects.requireNonNull(clock, "Clock es obligatorio");
    }

    @Override
    public Metrica registrar(UUID usuarioId, String nombre, double valor) {
        Metrica metrica = Metrica.registrar(usuarioId, nombre, valor, clock);
        return metricaGateway.guardar(metrica);
    }
}
