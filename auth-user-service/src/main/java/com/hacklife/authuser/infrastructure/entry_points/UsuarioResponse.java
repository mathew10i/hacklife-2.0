package com.hacklife.authuser.infrastructure.entry_points;

import com.hacklife.authuser.domain.model.Usuario;

import java.time.Instant;
import java.util.UUID;

public record UsuarioResponse(UUID id, String correo, String nombre, Instant creadoEn) {

    public static UsuarioResponse from(Usuario usuario) {
        return new UsuarioResponse(usuario.id(), usuario.correo(), usuario.nombre(), usuario.creadoEn());
    }
}
