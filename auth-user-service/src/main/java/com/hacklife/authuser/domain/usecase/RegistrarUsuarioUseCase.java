package com.hacklife.authuser.domain.usecase;

import com.hacklife.authuser.domain.model.Usuario;

public interface RegistrarUsuarioUseCase {

    Usuario registrar(String correo, String nombre);
}
