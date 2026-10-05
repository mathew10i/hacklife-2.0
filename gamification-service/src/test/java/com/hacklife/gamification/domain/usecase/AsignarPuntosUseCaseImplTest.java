package com.hacklife.gamification.domain.usecase;

import com.hacklife.gamification.domain.model.Puntos;
import com.hacklife.gamification.domain.model.gateway.PuntosGateway;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AsignarPuntosUseCaseImplTest {

    @Test
    void shouldAsignarPuntos() {
        Clock fixedClock = Clock.fixed(Instant.parse("2026-01-01T10:00:00Z"), ZoneOffset.UTC);
        CapturingPuntosGateway gateway = new CapturingPuntosGateway();
        AsignarPuntosUseCaseImpl useCase = new AsignarPuntosUseCaseImpl(gateway, fixedClock);

        Puntos puntos = useCase.asignar(UUID.fromString("55555555-5555-5555-5555-555555555555"), 10, "HABITO_COMPLETADO");

        assertEquals(10, puntos.valor());
        assertEquals("HABITO_COMPLETADO", puntos.motivo());
        assertEquals(Instant.parse("2026-01-01T10:00:00Z"), puntos.asignadoEn());
        assertEquals(puntos, gateway.saved);
    }

    private static final class CapturingPuntosGateway implements PuntosGateway {
        private Puntos saved;

        @Override
        public Puntos guardar(Puntos puntos) {
            this.saved = puntos;
            return puntos;
        }
    }
}
