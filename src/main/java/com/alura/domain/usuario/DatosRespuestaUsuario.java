package com.alura.domain.usuario;

public record DatosRespuestaUsuario(long id, String nombre, String email) {

    public DatosRespuestaUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getNombre(), usuario.getEmail());
    }
}
