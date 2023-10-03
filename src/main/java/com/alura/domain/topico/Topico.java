package com.alura.domain.topico;

import com.alura.domain.curso.Curso;
import com.alura.domain.respuesta.Respuesta;
import com.alura.domain.usuario.Usuario;
import jakarta.persistence.*;
import jakarta.validation.ValidationException;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Topico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String mensaje;
	private LocalDateTime fechaCreacion = LocalDateTime.now();

	@Enumerated(EnumType.STRING)
	private StatusTopico estatus = StatusTopico.NO_RESPONDIDO;

	@ManyToOne
	@JoinColumn(name = "id_autor")
	private Usuario autor;

	@ManyToOne
	@JoinColumn(name = "id_curso")
	private Curso curso;


	public Topico(String titulo, String mensaje, Curso curso) {
		this.titulo = titulo;
		this.mensaje = mensaje;
		this.curso = curso;
	}

	public Topico(DatosAgregarTopico datos) {
		this.titulo = datos.titulo();
		this.mensaje = datos.mensaje();
		this.fechaCreacion = LocalDateTime.now();
		this.estatus = StatusTopico.NO_RESPONDIDO;
	}

	public void setAutor(Usuario autor){
		this.autor = autor;
	}

	public void setCurso(Curso curso){
		this.curso = curso;
	}

	public void editar(DatosEditarTopico datos) {
		if (datos.titulo() != null){
			this.titulo = datos.titulo();
		}
		if (datos.mensaje() != null){
			this.mensaje = datos.mensaje();
		}
		if (datos.estatus() != null) {
			this.estatus = datos.estatus();
		}
	}
}
