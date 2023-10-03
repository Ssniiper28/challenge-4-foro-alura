package com.alura.controller;

import com.alura.domain.usuario.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<Page> listarUsuarios(Pageable paginacion){
        var usuarios = usuarioService.listaUsuarios(paginacion);
        return ResponseEntity.ok(usuarios.map(DatosRespuestaUsuario::new));
    }

    @PostMapping
    @Transactional
    public ResponseEntity agregarUsuario(@RequestBody @Valid DatosAgregarUsuario datos, UriComponentsBuilder uriComponentsBuilder){
        Usuario usuario = usuarioService.guardar(new Usuario(datos));
        URI url = uriComponentsBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(url).body(new DatosRespuestaUsuario(usuario.getId(), usuario.getNombre(), usuario.getEmail()));
    }
}
