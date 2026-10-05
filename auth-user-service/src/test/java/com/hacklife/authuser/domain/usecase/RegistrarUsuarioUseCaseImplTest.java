package com.hacklife.authuser.domain.usecase;

import com.hacklife.authuser.domain.model.Usuario;
import com.hacklife.authuser.domain.model.gateway.UsuarioGateway;
import org.junit.jupiter.api.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RegistrarUsuarioUseCaseImplTest {

    @Test
    void shouldRegisterUsuario() {
        Clock fixedClock = Clock.fixed(Instant.parse("2026-01-01T10:00:00Z"), ZoneOffset.UTC);
        CapturingUsuarioGateway gateway = new CapturingUsuarioGateway();
        RegistrarUsuarioUseCaseImpl useCase = new RegistrarUsuarioUseCaseImpl(gateway, fixedClock);

        Usuario usuario = useCase.registrar("ana@hacklife.com", "Ana");

        assertEquals("ana@hacklife.com", usuario.correo());
        assertEquals("Ana", usuario.nombre());
        assertEquals(Instant.parse("2026-01-01T10:00:00Z"), usuario.creadoEn());
        assertEquals(usuario, gateway.saved);
    }

    private static final class CapturingUsuarioGateway implements UsuarioGateway {
        private Usuario saved;

        @Override
        public Usuario guardar(Usuario usuario) {
            this.saved = usuario;
            return usuario;
        }
    }
}
