package com.hacklife.habitstreak.domain.usecase;

import com.hacklife.habitstreak.domain.model.FrecuenciaHabito;
import com.hacklife.habitstreak.domain.model.Habito;
import com.hacklife.habitstreak.domain.model.gateway.HabitoGateway;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CrearHabitoUseCaseImplTest {

    @Test
    void shouldCreateHabito() {
        Clock fixedClock = Clock.fixed(Instant.parse("2026-01-01T10:00:00Z"), ZoneOffset.UTC);
        CapturingHabitoGateway gateway = new CapturingHabitoGateway();
        CrearHabitoUseCaseImpl useCase = new CrearHabitoUseCaseImpl(gateway, fixedClock);

        Habito habito = useCase.crear(UUID.fromString("22222222-2222-2222-2222-222222222222"), "Leer", FrecuenciaHabito.DIARIO);

        assertEquals("Leer", habito.nombre());
        assertEquals(FrecuenciaHabito.DIARIO, habito.frecuencia());
        assertEquals(Instant.parse("2026-01-01T10:00:00Z"), habito.creadoEn());
        assertEquals(habito, gateway.saved);
    }

    private static final class CapturingHabitoGateway implements HabitoGateway {
        private Habito saved;

        @Override
        public Habito guardar(Habito habito) {
            this.saved = habito;
            return habito;
        }
    }
}
