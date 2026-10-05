package com.hacklife.authuser.infrastructure.driver_adapter;

import com.hacklife.authuser.domain.model.Usuario;
import com.hacklife.authuser.domain.model.gateway.UsuarioGateway;
import com.hacklife.authuser.infrastructure.mappers.UsuarioMapper;
import org.springframework.stereotype.Component;

@Component
public class UsuarioDataGatewayImpl implements UsuarioGateway {

    private final UsuarioDataJpaRepository usuarioDataJpaRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioDataGatewayImpl(UsuarioDataJpaRepository usuarioDataJpaRepository, UsuarioMapper usuarioMapper) {
        this.usuarioDataJpaRepository = usuarioDataJpaRepository;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        UsuarioData saved = usuarioDataJpaRepository.save(usuarioMapper.toData(usuario));
        return usuarioMapper.toDomain(saved);
    }
}
