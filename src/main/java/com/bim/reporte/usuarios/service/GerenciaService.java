package com.bim.reporte.usuarios.service;

import java.util.List;

import com.bim.reporte.usuarios.request.GerenciaRequest;
import com.bim.reporte.usuarios.response.GerenciaResponse;

public interface GerenciaService {

	public List<GerenciaResponse> listaGerencias();
	
	public List<GerenciaResponse> listaGerenciasId(int idGerencia);
	
	public void crearGerencia(GerenciaRequest gerenciaRequest);
	
	public void modificarGerencia(int id,GerenciaRequest gerenciaRequest);
}
