package com.alura.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record DatosEditarTopico(String titulo, String mensaje, StatusTopico estatus) {
}
