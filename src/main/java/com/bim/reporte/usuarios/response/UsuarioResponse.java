package com.bim.reporte.usuarios.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class UsuarioResponse {

	private int idUsuario;
	private String usuario;
	//private String gerencia;
}
