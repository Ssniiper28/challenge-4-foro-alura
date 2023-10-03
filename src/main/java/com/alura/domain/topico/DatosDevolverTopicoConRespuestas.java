package com.alura.domain.topico;

import com.alura.domain.respuesta.DatosDevolverRespuesta;

import java.util.List;

public record DatosDevolverTopicoConRespuestas(DatosDevolverTopico datosDevolverTopico, List<DatosDevolverRespuesta> listaRespuestas) {
}
