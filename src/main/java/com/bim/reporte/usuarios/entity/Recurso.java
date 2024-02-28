package com.bim.reporte.usuarios.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "recurso")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Recurso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRecurso;
	
	/*@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_usuario",referencedColumnName = "id_usuario")
	private List<Usuario> usuario;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_gerencia",referencedColumnName = "id_gerencia")
	private List<Gerencia> gerencia;*/
}
