package com.bim.reporte.usuarios.service;

import java.util.List;

import com.bim.reporte.usuarios.entity.Gerencia;
import com.bim.reporte.usuarios.entity.Recurso;
import com.bim.reporte.usuarios.entity.Usuario;
import com.bim.reporte.usuarios.request.UsuarioRequest;
import com.bim.reporte.usuarios.response.GerenciaResponse;
import com.bim.reporte.usuarios.response.PersonaResponse;
import com.bim.reporte.usuarios.response.ProyectoUsuarioResponse;
import com.bim.reporte.usuarios.response.RecursosPersonaResponse;
import com.bim.reporte.usuarios.response.RecursosResponse;
import com.bim.reporte.usuarios.response.UsuarioResponse;

public interface UsuarioService {

	public List<PersonaResponse> listaPersonas();
	
	public List<UsuarioResponse> listaUsuarios();
	
	public List<Usuario> listaUsuariosGerencia();
	
	public List<Gerencia> listaUsuariosGerencias();
	
	public List<RecursosResponse> listaRecursosGerencias();
	
	public List<RecursosPersonaResponse> lista();
	
	public List<RecursosPersonaResponse> listaGerencia(int id);
	
	public List<RecursosResponse> listaRecursoPorGerencia(int idGerencia);
	
	public void crearUsuario(UsuarioRequest usuarioRequest);
	
	public void modficarUsuario(int idUsuario,UsuarioRequest usuarioRequest);
	
	public List<ProyectoUsuarioResponse> listaProyectoUsuario();
}
