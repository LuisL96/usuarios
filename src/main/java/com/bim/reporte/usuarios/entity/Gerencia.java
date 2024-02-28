package com.bim.reporte.usuarios.entity;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data

public class Gerencia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_gerencia")
	private int idGerencia;
	
	private String gerencia;
	
	/*@ManyToMany
    @JoinTable(name = "usuario_gerencia",
        joinColumns =@JoinColumn(name="id_gerencia"),
        inverseJoinColumns = @JoinColumn(name= "id_usuario"))
	private List<Usuario> usuarios;*/
	
	@ManyToMany(mappedBy = "gerencias")
	@JsonIgnore
    private List<Usuario> usuarios;
	
	public Boolean status;
  
	
	/*@OneToMany(mappedBy = "gerencia")
	private List<Usuario> usuarios;*/
	
}
