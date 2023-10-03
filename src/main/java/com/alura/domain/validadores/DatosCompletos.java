package com.alura.domain.validadores;

import com.alura.domain.topico.DatosAgregarTopico;
import org.springframework.stereotype.Component;

@Component
public class DatosCompletos implements ValidadorDeDatos{
    @Override
    public void validar(DatosAgregarTopico datos) {
        if (datos.id_autor() == null || datos.mensaje() == null || datos.id_curso() == null || datos.titulo() == null) {
            throw new RuntimeException("Faltan datos");
        }
    }
}
