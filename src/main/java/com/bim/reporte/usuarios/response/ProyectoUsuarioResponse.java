package com.bim.reporte.usuarios.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProyectoUsuarioResponse {

	private int idProy;
	private int idUsuario;
	private String usuario;
}
