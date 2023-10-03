package com.alura.domain.topico;

import java.time.LocalDateTime;

public record DatosRespuestaTopicos(
        long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        StatusTopico estatus,
        String autor,
        String curso
) {
    public DatosRespuestaTopicos(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion()
        , topico.getEstatus(), topico.getAutor().getNombre(), topico.getCurso().getNombre());
    }
}
