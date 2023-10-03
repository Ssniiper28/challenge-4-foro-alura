package com.alura.controller;

import com.alura.domain.respuesta.DatosAgregarRespuesta;
import com.alura.domain.respuesta.Respuesta;
import com.alura.domain.respuesta.RespuestaRepository;
import com.alura.domain.topico.TopicoRepository;
import com.alura.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/respuesta")
public class RespuestaController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private RespuestaRepository respuestaRepository;

    @PostMapping
    public ResponseEntity guardarRespuesta(@RequestBody DatosAgregarRespuesta datos){
        var respuesta = new Respuesta(datos);
        var topico = topicoRepository.findById(datos.id_topico()).get();
        var autor = usuarioRepository.findById(datos.id_autor()).get();
        respuesta.setTopico(topico);
        respuesta.setAutor(autor);
        respuestaRepository.save(respuesta);
        return ResponseEntity.ok(respuesta);
    }
}
