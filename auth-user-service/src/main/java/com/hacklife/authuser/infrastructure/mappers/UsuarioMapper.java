package com.hacklife.authuser.infrastructure.mappers;

import com.hacklife.authuser.domain.model.Usuario;
import com.hacklife.authuser.infrastructure.driver_adapter.UsuarioData;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioData toData(Usuario usuario) {
        return new UsuarioData(usuario.id(), usuario.correo(), usuario.nombre(), usuario.creadoEn());
    }

    public Usuario toDomain(UsuarioData data) {
        return new Usuario(data.getId(), data.getCorreo(), data.getNombre(), data.getCreadoEn());
    }
}
