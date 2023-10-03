package com.alura.domain.respuesta;

import java.time.LocalDateTime;

public record DatosDevolverRespuesta(
        String mensaje,
        LocalDateTime fecha_creacion,
        String topico,
        String autor,
        Boolean solucion
) {
}
