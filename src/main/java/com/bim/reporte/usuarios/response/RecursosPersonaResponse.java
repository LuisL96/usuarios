package com.bim.reporte.usuarios.response;

import java.util.List;

import com.bim.reporte.usuarios.entity.Usuario;

import lombok.Data;

@Data
public class RecursosPersonaResponse {

	private GerenciaResponse gerencia;
	private List<PersonaResponse> usuarios;
}
