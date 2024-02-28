package com.bim.reporte.usuarios.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class Roles {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_rol")
	private int idRol;
	
	@Column(name = "rol_vch")
	private String rol;
	
	@Column(name = "status_bln")
	private int status;
	
	@OneToMany(mappedBy = "roles")
    Set<UsuarioRol> usuarioRol;
}
