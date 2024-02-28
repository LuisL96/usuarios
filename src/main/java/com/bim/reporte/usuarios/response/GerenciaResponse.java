package com.bim.reporte.usuarios.response;

import java.util.List;

import com.bim.reporte.usuarios.entity.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class GerenciaResponse {

	public int idGerencia;
	public String gerencia;
	//public List<UsuarioResponse> usuario;
}
