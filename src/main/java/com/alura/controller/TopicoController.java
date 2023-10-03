package com.alura.controller;

import com.alura.domain.curso.CursoRepository;
import com.alura.domain.respuesta.DatosDevolverRespuesta;
import com.alura.domain.respuesta.RespuestaRepository;
import com.alura.domain.topico.*;
import com.alura.domain.usuario.UsuarioRepository;
import com.alura.domain.validadores.ValidadorDeDatos;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    List<ValidadorDeDatos> validadores;

    @PostMapping
    @Transactional
    public ResponseEntity agregarTopico(@RequestBody @Valid DatosAgregarTopico datos) {
        validadores.forEach(validador -> validador.validar(datos));
        var topico = new Topico(datos);
        var autor = usuarioRepository.findById(datos.id_autor()).get();
        var curso = cursoRepository.findById(datos.id_curso()).get();
        topico.setAutor(autor);
        topico.setCurso(curso);
        topicoRepository.save(topico);
        return ResponseEntity.ok(new DatosRespuestaTopicos(topico));
    }

    @GetMapping
    public ResponseEntity<Page> listarTopicos(Pageable paginacion) {
        var topicos = topicoRepository.findAll(paginacion).map(DatosRespuestaTopicos::new);
        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity buscarTopico(@PathVariable Long id) {
        Topico topico;
        try {
            topico = topicoRepository.findById(id).get();
        } catch (Exception e){
            return ResponseEntity.notFound().build();
        }
        List<DatosDevolverRespuesta> listaRespuestas = new ArrayList<>();
        respuestaRepository.findAllByTopico(topico).forEach(respuesta -> {
            listaRespuestas.add(new DatosDevolverRespuesta(
                    respuesta.getMensaje(),
                    respuesta.getFecha_creacion(),
                    respuesta.getTopico().getTitulo(),
                    respuesta.getAutor().getNombre(),
                    respuesta.getSolucion()
            ));
        });

        return ResponseEntity.ok(new DatosDevolverTopicoConRespuestas(new DatosDevolverTopico(
                        topico.getTitulo(),
                        topico.getMensaje(),
                        topico.getFechaCreacion(),
                        topico.getEstatus(),
                        topico.getAutor().getNombre(),
                        topico.getCurso().getNombre()
                ), listaRespuestas)
        );
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity editarTopico(@PathVariable Long id, @RequestBody @Valid DatosEditarTopico datos) {
        Topico topico;
        try {
            topico = topicoRepository.findById(id).get();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        topico.editar(datos);
        return ResponseEntity.ok("");
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        System.out.println("ID RECIBIDO: " + id);
        try {
            topicoRepository.deleteById(id);
            return ResponseEntity.ok("");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
