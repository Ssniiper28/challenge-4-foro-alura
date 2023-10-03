package com.alura.domain.respuesta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosAgregarRespuesta(@NotBlank String mensaje, @NotNull long id_topico,@NotNull long id_autor) {
}
