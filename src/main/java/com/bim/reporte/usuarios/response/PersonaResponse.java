package com.bim.reporte.usuarios.response;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class PersonaResponse {

	private int idUsuario;
	private String nombre;
	private String apellido;
	private String correo;
	private boolean status;
	private Set<GerenciaResponse> gerencia;
	private Set<RolResponse> rol;
	
}
