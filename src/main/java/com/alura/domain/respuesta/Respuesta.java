package com.alura.domain.respuesta;

import com.alura.domain.topico.Topico;
import com.alura.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Respuesta")
@Table(name = "respuestas")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Respuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String mensaje;

	@ManyToOne
	@JoinColumn(name = "id_topico")
	private Topico topico;

	private LocalDateTime fecha_creacion = LocalDateTime.now();

	@OneToOne
	@JoinColumn(name = "id_autor_mensaje")
	private Usuario autor;

	private Boolean solucion = false;

	public Respuesta(DatosAgregarRespuesta datos) {
		this.mensaje = datos.mensaje();
		this.fecha_creacion = LocalDateTime.now();
		this.solucion = false;
	}

	public void setTopico(Topico topico){
		this.topico = topico;
	}

	public void setAutor(Usuario autor){
		this.autor = autor;
	}
}
