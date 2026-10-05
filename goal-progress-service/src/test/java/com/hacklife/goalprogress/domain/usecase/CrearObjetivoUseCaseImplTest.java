package com.hacklife.goalprogress.domain.usecase;

import com.hacklife.goalprogress.domain.model.Objetivo;
import com.hacklife.goalprogress.domain.model.gateway.ObjetivoGateway;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CrearObjetivoUseCaseImplTest {

    @Test
    void shouldCreateObjetivo() {
        Clock fixedClock = Clock.fixed(Instant.parse("2026-01-01T10:00:00Z"), ZoneOffset.UTC);
        CapturingObjetivoGateway gateway = new CapturingObjetivoGateway();
        CrearObjetivoUseCaseImpl useCase = new CrearObjetivoUseCaseImpl(gateway, fixedClock);

        Objetivo objetivo = useCase.crear(UUID.fromString("33333333-3333-3333-3333-333333333333"), "Correr", 30);

        assertEquals("Correr", objetivo.titulo());
        assertEquals(30, objetivo.meta());
        assertEquals(Instant.parse("2026-01-01T10:00:00Z"), objetivo.creadoEn());
        assertEquals(objetivo, gateway.saved);
    }

    private static final class CapturingObjetivoGateway implements ObjetivoGateway {
        private Objetivo saved;

        @Override
        public Objetivo guardar(Objetivo objetivo) {
            this.saved = objetivo;
            return objetivo;
        }
    }
}
