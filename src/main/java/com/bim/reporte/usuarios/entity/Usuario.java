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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "usuario")
@Data

public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private int idUsuario;
	
	@Column(name = "nombre_vch")
	private String nombre;
	
	@Column(name = "apellido_vch")
	private String apellido;
	
	@Column(name = "correo_vch")
	private String correo;
	
	//private String pass;
	
	@Column(name = "status_bln")
	private boolean status;
	
	/*@OneToMany(mappedBy = "usuario")
    Set<UsuarioRol> usuarioRol;*/
	
	/*@ManyToMany(mappedBy = "usuarios")
    private Set<Gerencia> gerencias;*/
	
	@ManyToMany
    @JoinTable(name = "usuario_roles",
        joinColumns =@JoinColumn(name="id_usuario"),
        inverseJoinColumns = @JoinColumn(name= "id_rol"))
	@JsonIgnore
	private Set<Roles> roles;
	
	@ManyToMany
    @JoinTable(name = "usuario_gerencia",
        joinColumns =@JoinColumn(name="id_usuario"),
        inverseJoinColumns = @JoinColumn(name= "id_gerencia"))
	@JsonIgnore
	private Set<Gerencia> gerencias;
	
	/*@OneToMany(mappedBy = "usuario")
    Set<ProyectoRecurso> registrations;
	*/
	
	/*@ManyToMany
    @JoinTable(name = "usuario_gerencia",
        joinColumns =@JoinColumn(name="id_usuario"),
        inverseJoinColumns = @JoinColumn(name= "id_gerencia"))
	private List<Gerencia> gerencia;*/
}
