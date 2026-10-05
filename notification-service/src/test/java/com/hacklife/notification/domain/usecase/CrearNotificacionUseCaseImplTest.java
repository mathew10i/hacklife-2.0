package com.hacklife.notification.domain.usecase;

import com.hacklife.notification.domain.model.Notificacion;
import com.hacklife.notification.domain.model.gateway.NotificacionGateway;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CrearNotificacionUseCaseImplTest {

    @Test
    void shouldCreateNotificacion() {
        Clock fixedClock = Clock.fixed(Instant.parse("2026-01-01T10:00:00Z"), ZoneOffset.UTC);
        CapturingNotificacionGateway gateway = new CapturingNotificacionGateway();
        CrearNotificacionUseCaseImpl useCase = new CrearNotificacionUseCaseImpl(gateway, fixedClock);

        Notificacion notificacion = useCase.crear(UUID.fromString("44444444-4444-4444-4444-444444444444"), "Recuerda tu hábito");

        assertEquals("Recuerda tu hábito", notificacion.mensaje());
        assertEquals(Instant.parse("2026-01-01T10:00:00Z"), notificacion.creadaEn());
        assertEquals(notificacion, gateway.saved);
    }

    private static final class CapturingNotificacionGateway implements NotificacionGateway {
        private Notificacion saved;

        @Override
        public Notificacion guardar(Notificacion notificacion) {
            this.saved = notificacion;
            return notificacion;
        }
    }
}
