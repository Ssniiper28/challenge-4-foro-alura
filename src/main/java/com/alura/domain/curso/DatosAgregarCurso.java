package com.alura.domain.curso;

import jakarta.validation.constraints.NotNull;

public record DatosAgregarCurso(@NotNull String nombre, @NotNull String categoria) {
}
