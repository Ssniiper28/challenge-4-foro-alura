package com.alura.domain.curso;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Curso")
@Table(name = "cursos")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String categoria;

	public Curso(String nombre, String categoria) {
		this.nombre = nombre;
		this.categoria = categoria;
	}

	public Curso(DatosAgregarCurso datos) {
		this.nombre = datos.nombre();
		this.categoria = datos.categoria();
	}
}
