package com.alura.domain.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public record DatosAgregarUsuario(
        @NotNull
        String nombre,

        @NotNull
        @Email
        String email,

        @NotNull
        String pass
) {
}
