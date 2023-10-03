package com.alura.domain.curso;

public record DatosRespuestaCurso(long id, String nombre, String categoria) {

    public DatosRespuestaCurso(Curso curso){
        this(curso.getId(), curso.getNombre(), curso.getCategoria());
    }
}
