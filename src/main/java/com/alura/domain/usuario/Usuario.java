package com.alura.domain.usuario;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Usuario")
@Table(name = "usuarios")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nombre;
	private String email;
	private String pass;


	public Usuario(DatosAgregarUsuario datos) {
		this.nombre = datos.nombre();
		this.email = datos.email();
		this.pass = datos.pass();
	}

	public void setPass(String pass){
		this.pass = pass;
	}
}
