package com.alura.controller;

import com.alura.domain.curso.Curso;
import com.alura.domain.curso.CursoRepository;
import com.alura.domain.curso.DatosAgregarCurso;
import com.alura.domain.curso.DatosRespuestaCurso;
import com.alura.domain.usuario.DatosRespuestaUsuario;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/curso")
public class CursoController {

    @Autowired
    private CursoRepository cursoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity agregarCurso(@RequestBody @Valid DatosAgregarCurso datos, UriComponentsBuilder uriComponentsBuilder){
        var curso = cursoRepository.save(new Curso(datos));
        var url = uriComponentsBuilder.path("/curso/{id}").buildAndExpand(curso.getId()).toUri();
        return ResponseEntity.created(url).body(new DatosRespuestaCurso(curso.getId(), curso.getNombre(), curso.getCategoria()));
    }

    @GetMapping
    public ResponseEntity<Page> listarUsuarios(Pageable paginacion){
        var usuarios = cursoRepository.findAll(paginacion);
        return ResponseEntity.ok(usuarios.map(DatosRespuestaCurso::new));
    }
}
