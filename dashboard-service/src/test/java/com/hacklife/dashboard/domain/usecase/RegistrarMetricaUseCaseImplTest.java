package com.hacklife.dashboard.domain.usecase;

import com.hacklife.dashboard.domain.model.Metrica;
import com.hacklife.dashboard.domain.model.gateway.MetricaGateway;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RegistrarMetricaUseCaseImplTest {

    @Test
    void shouldRegistrarMetrica() {
        Clock fixedClock = Clock.fixed(Instant.parse("2026-01-01T10:00:00Z"), ZoneOffset.UTC);
        CapturingMetricaGateway gateway = new CapturingMetricaGateway();
        RegistrarMetricaUseCaseImpl useCase = new RegistrarMetricaUseCaseImpl(gateway, fixedClock);

        Metrica metrica = useCase.registrar(UUID.fromString("66666666-6666-6666-6666-666666666666"), "racha_actual", 7);

        assertEquals("racha_actual", metrica.nombre());
        assertEquals(7, metrica.valor());
        assertEquals(Instant.parse("2026-01-01T10:00:00Z"), metrica.registradaEn());
        assertEquals(metrica, gateway.saved);
    }

    private static final class CapturingMetricaGateway implements MetricaGateway {
        private Metrica saved;

        @Override
        public Metrica guardar(Metrica metrica) {
            this.saved = metrica;
            return metrica;
        }
    }
}
