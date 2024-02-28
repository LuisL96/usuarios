package com.bim.reporte.usuarios.request;

import lombok.Data;

@Data
public class UsuarioRequest {

	private int idGerencia;
	private String apellido;
	private String correo;
	private String nombre;
	private boolean status;
	private String pass;
	
}
