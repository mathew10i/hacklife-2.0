package com.hacklife.authuser.infrastructure.entry_points;

import com.hacklife.authuser.domain.model.Usuario;
import com.hacklife.authuser.domain.usecase.RegistrarUsuarioUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {

    private final RegistrarUsuarioUseCase registrarUsuarioUseCase;

    public UsuarioController(RegistrarUsuarioUseCase registrarUsuarioUseCase) {
        this.registrarUsuarioUseCase = registrarUsuarioUseCase;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> crear(@Valid @RequestBody CrearUsuarioRequest request) {
        Usuario usuario = registrarUsuarioUseCase.registrar(request.correo(), request.nombre());
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioResponse.from(usuario));
    }
}
