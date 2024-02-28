package com.bim.reporte.usuarios.response;

import java.util.List;

import com.bim.reporte.usuarios.entity.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class RecursosResponse {

	private GerenciaResponse gerencia;
	private List<Usuario> usuario;
	
	public RecursosResponse(GerenciaResponse gerencia, List<Usuario> usuario) {
		super();
		this.gerencia = gerencia;
		this.usuario = usuario;
	}
}
