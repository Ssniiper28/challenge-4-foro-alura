package com.alura.domain.topico;

import com.alura.domain.respuesta.Respuesta;

import java.time.LocalDateTime;
import java.util.List;

public record DatosDevolverTopico (String titulo, String mensaje, LocalDateTime fechaCreacion, StatusTopico estatus, String autor, String curso){
}
