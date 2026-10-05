package com.hacklife.authuser.domain.usecase;

import com.hacklife.authuser.domain.model.Usuario;
import com.hacklife.authuser.domain.model.gateway.UsuarioGateway;

import java.time.Clock;
import java.util.Objects;

public class RegistrarUsuarioUseCaseImpl implements RegistrarUsuarioUseCase {

    private final UsuarioGateway usuarioGateway;
    private final Clock clock;

    public RegistrarUsuarioUseCaseImpl(UsuarioGateway usuarioGateway, Clock clock) {
        this.usuarioGateway = Objects.requireNonNull(usuarioGateway, "UsuarioGateway es obligatorio");
        this.clock = Objects.requireNonNull(clock, "Clock es obligatorio");
    }

    @Override
    public Usuario registrar(String correo, String nombre) {
        Usuario usuario = Usuario.crearNuevo(correo, nombre, clock);
        return usuarioGateway.guardar(usuario);
    }
}
