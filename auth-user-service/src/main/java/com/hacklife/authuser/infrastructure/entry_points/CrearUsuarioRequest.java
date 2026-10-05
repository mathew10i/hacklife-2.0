package com.hacklife.authuser.infrastructure.entry_points;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CrearUsuarioRequest(
        @Email @NotBlank String correo,
        @NotBlank String nombre
) {
}
