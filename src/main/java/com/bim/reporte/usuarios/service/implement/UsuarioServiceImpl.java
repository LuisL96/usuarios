package com.bim.reporte.usuarios.service.implement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bim.reporte.usuarios.entity.Gerencia;
import com.bim.reporte.usuarios.entity.Proyecto;
import com.bim.reporte.usuarios.entity.ProyectoRecurso;
import com.bim.reporte.usuarios.entity.Recurso;
import com.bim.reporte.usuarios.entity.Usuario;
import com.bim.reporte.usuarios.repository.GerenciaRepository;

import com.bim.reporte.usuarios.repository.RecursoRepository;
import com.bim.reporte.usuarios.repository.UsuarioRepository;
import com.bim.reporte.usuarios.request.UsuarioRequest;
import com.bim.reporte.usuarios.response.GerenciaResponse;
import com.bim.reporte.usuarios.response.PersonaResponse;
import com.bim.reporte.usuarios.response.ProyectoUsuarioResponse;
import com.bim.reporte.usuarios.response.RecursosPersonaResponse;
import com.bim.reporte.usuarios.response.RecursosResponse;
import com.bim.reporte.usuarios.response.RolResponse;
import com.bim.reporte.usuarios.response.UsuarioResponse;
import com.bim.reporte.usuarios.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private RecursoRepository recursoRepository;
	
	@Autowired
	private GerenciaRepository gerenciaRepository;
	

	
	@Override
	public List<UsuarioResponse> listaUsuarios() {
		// TODO Auto-generated method stub
		List<Usuario> listaUsuario = usuarioRepository.findAll();
		
		List<UsuarioResponse> listaUsuarioResponse  = listaUsuario.stream()
				.map(lstUsuario ->
				new UsuarioResponse(
						lstUsuario.getIdUsuario(),
						lstUsuario.getNombre()
						)
				).collect(Collectors.toList());
		
		return listaUsuarioResponse;
	}

	@Override
	public List<Usuario> listaUsuariosGerencia() {
		// TODO Auto-generated method stub
		List<Usuario> listaUsuario = usuarioRepository.findAll();
		
		/*List<GerenciaResponse> listaGerenciaResponse = listaUsuario.stream()
				.map(lstGerencia ->
					new GerenciaResponse(
					lstGerencia.getGerencia().getIdGerencia(),
					lstGerencia.getGerencia().getGerencia(),
					new List<UsuarioResponse> (lstGerencia.getUsuario().getIdUsuario())
				)
			).collect(Collectors.toList());
		
		return listaGerenciaResponse;*/
		
		return listaUsuario;
		
		
	}

	@Override
	public List<Gerencia> listaUsuariosGerencias() {
		// TODO Auto-generated method stub
		List<Gerencia> listaGere = gerenciaRepository.findAll();
		
		return listaGere;
	}

	@Override
	public List<RecursosResponse> listaRecursosGerencias() {
		// TODO Auto-generated method stub
		List<Gerencia> listaGerencia = gerenciaRepository.findAll();
		
		//List<PersonaResponse> usuario = listaGerencia.
		
		List<RecursosResponse> lst = listaGerencia.stream()
				.map(lsts -> (
						new RecursosResponse( 
							new GerenciaResponse(
									lsts.getIdGerencia(),
									lsts.getGerencia()
									),lsts.getUsuarios())
						)).collect(Collectors.toList());
				return lst;
		//List<Usuario> listaUsuario = listaGerencia.get(0).getUsuarios();
		
		//List<Usuario> lst = usuarioRepository.(1);
		
		//List<UsuarioResponse> listaUsuarioResponse = listaUsuario.get(0).getIdUsuario()
		/*List<RecursosResponse> listaRecursosResponse = listaGerencia.stream()
				.map(lstRecurso ->{
					List<Usuario> lst = usuarioRepository.findByGerencias(lstRecurso.getIdGerencia());
					
					new RecursosResponse(
							new GerenciaResponse(lstRecurso.getIdGerencia(),lstRecurso.getGerencia()),
							lst
							);
				}).collect(Collectors.toList());*/
		
		
				
		
		/*return listaGerencia.stream()
				.map(lstRecurso -> {
					List<Usuario> lst = usuarioRepository.findByGerencias(1);
					new GerenciaResponse(lstRecurso.getIdGerencia(), lstRecurso.getGerencia(), lst);
				}).collect(Collectors.toList());*/
		
		
	}

	@Override
	public List<RecursosResponse> listaRecursoPorGerencia(int idGerencia) {
		// TODO Auto-generated method stub
		Optional<Gerencia> listaGerencia = gerenciaRepository.findById(idGerencia);
		
		List<RecursosResponse> listaRecurso = listaGerencia.stream()
				.map(lstRecurso ->
					new RecursosResponse(
							new GerenciaResponse(
									lstRecurso.getIdGerencia(),
									lstRecurso.getGerencia()
									)
							,
							lstRecurso.getUsuarios()
							)
				).collect(Collectors.toList());
		return listaRecurso;
	}

	@Override
	public void crearUsuario(UsuarioRequest usuarioRequest) {
		// TODO Auto-generated method stub
		
		
		
		Usuario usuarioEnt = new Usuario();
		
		Gerencia gerenciaEnt = gerenciaRepository.findById(usuarioRequest.getIdGerencia()).orElse(null); 
		
		System.out.println("id nom: " + gerenciaEnt.getIdGerencia()  +  " -" + gerenciaEnt.getGerencia());
		usuarioEnt.setApellido(usuarioRequest.getApellido());
		usuarioEnt.setCorreo(usuarioRequest.getCorreo());
		usuarioEnt.setNombre(usuarioRequest.getNombre());
		usuarioEnt.setStatus(usuarioRequest.isStatus());
		
		/*List<Gerencia> gerenciaEnt = gerenciaRepository.findAllById(usuarioRequest.getIdGerencia()).orElseThrow(); 
		System.out.println("Gerencia: " + gerenciaEnt.getGerencia());
		*/
		/*if (usuarioEnt.getGerencias() == null) {
			usuarioEnt.setGerencias(new ArrayList<>());
	    }*/
		//usuarioEnt.setGerencias(new ArrayList<>());
		
		usuarioEnt.setGerencias(new HashSet<>());
		
		usuarioEnt.getGerencias().add(gerenciaEnt);
		
		usuarioRepository.save(usuarioEnt);
		
		
		
		
	}

	@Override
	public void modficarUsuario(int idUsuario, UsuarioRequest usuarioRequest) {
		// TODO Auto-generated method stub
		Usuario usuarioEnt = usuarioRepository.findById(idUsuario).orElseThrow(null);
		
		usuarioEnt.setApellido(usuarioRequest.getApellido());
		usuarioEnt.setCorreo(usuarioRequest.getCorreo());
		usuarioEnt.setNombre(usuarioRequest.getNombre());
		//usuarioEnt.setPass("4567");
		usuarioEnt.setStatus(usuarioRequest.isStatus());
		
		usuarioRepository.save(usuarioEnt);
	}

	@Override
	public List<RecursosPersonaResponse> lista() {
		// TODO Auto-generated method stub
		List<Gerencia> listaUsuarioEnt = gerenciaRepository.findAll();
		
		Gerencia gerenciaEnt = new Gerencia();
		
		RecursosPersonaResponse personaResponse = new RecursosPersonaResponse();
		List<RecursosPersonaResponse> li = new ArrayList<>();
		for(Gerencia geren : listaUsuarioEnt) {
			
			GerenciaResponse gerenciaResponse = new GerenciaResponse();
			
			gerenciaResponse.setGerencia(geren.getGerencia());
			gerenciaResponse.setIdGerencia(geren.getIdGerencia());
			List<PersonaResponse> lista = new ArrayList<>();
			for(Usuario persona : geren.getUsuarios()) {
				PersonaResponse personaResponse2 = new PersonaResponse();
				personaResponse2.setApellido(persona.getApellido());
				personaResponse2.setCorreo(persona.getCorreo());
				personaResponse2.setIdUsuario(persona.getIdUsuario());
				personaResponse2.setNombre(persona.getNombre());
				personaResponse2.setStatus(persona.isStatus());
				
				lista.add(personaResponse2);
			}
			
			personaResponse.setGerencia(gerenciaResponse);
			personaResponse.setUsuarios(lista);
			
			li.add(personaResponse);
			
		}
		
		return li;
	}

	@Override
	public List<RecursosPersonaResponse> listaGerencia(int id) {
		// TODO Auto-generated method stub
		Optional<Gerencia> geren = gerenciaRepository.findById(id);
		
		Gerencia gerenciaEnt = new Gerencia();
		
		RecursosPersonaResponse personaResponse = new RecursosPersonaResponse();
		List<RecursosPersonaResponse> li = new ArrayList<>();
		//for(Gerencia geren : listaUsuarioEnt) {
			
			GerenciaResponse gerenciaResponse = new GerenciaResponse();
			
			gerenciaResponse.setGerencia(geren.get().getGerencia());
			gerenciaResponse.setIdGerencia(geren.get().getIdGerencia());
			List<PersonaResponse> lista = new ArrayList<>();
			for(Usuario persona : geren.get().getUsuarios()) {
				PersonaResponse personaResponse2 = new PersonaResponse();
				personaResponse2.setApellido(persona.getApellido());
				personaResponse2.setCorreo(persona.getCorreo());
				personaResponse2.setIdUsuario(persona.getIdUsuario());
				personaResponse2.setNombre(persona.getNombre());
				personaResponse2.setStatus(persona.isStatus());
				
				lista.add(personaResponse2);
			}
			
			personaResponse.setGerencia(gerenciaResponse);
			personaResponse.setUsuarios(lista);
			
			li.add(personaResponse);
			
		//}
		
		return li;
	}

	@Override
	public List<ProyectoUsuarioResponse> listaProyectoUsuario() {
		// TODO Auto-generated method stub
		/*List<ProyectoRecurso> listaProyRecursoEnt = proyectoRecursoRepository.findAll();
		
		List<ProyectoUsuarioResponse> listaProyResponse = listaProyRecursoEnt.stream()
				.map(lstProyUsu ->
						new ProyectoUsuarioResponse(
								lstProyUsu.getProyecto().idProyecto,
								lstProyUsu.getUsuario().getIdUsuario(),
								lstProyUsu.getUsuario().getNombre()
								)
						).collect(Collectors.toList());*/
		return null;
	}

	@Override
	public List<PersonaResponse> listaPersonas() {
		// TODO Auto-generated method stub
		List<Usuario> lstUsuarioEnt = usuarioRepository.findAll();
		
		List<PersonaResponse> lstPersonaResponses = lstUsuarioEnt.stream()
				.map(lstPersona -> {
					PersonaResponse personaResponse = new PersonaResponse();
					personaResponse.setApellido(lstPersona.getApellido());
					personaResponse.setCorreo(lstPersona.getCorreo());
					personaResponse.setIdUsuario(lstPersona.getIdUsuario());
					personaResponse.setNombre(lstPersona.getNombre());
					personaResponse.setStatus(lstPersona.isStatus());
					personaResponse.setGerencia(lstPersona.getGerencias().stream()
							.map(lstPersonaGeren -> 
							new GerenciaResponse(
									lstPersonaGeren.getIdGerencia(),
									lstPersonaGeren.getGerencia()
									)).collect(Collectors.toSet()));
					
					personaResponse.setRol(lstPersona.getRoles().stream()
							.map(lstPersonaRol -> 
							new RolResponse(
									lstPersonaRol.getIdRol(),
									lstPersonaRol.getRol()
									)
							).collect(Collectors.toSet()));
					return personaResponse;
					
				}).collect(Collectors.toList());
		
		return lstPersonaResponses;
		
		
	}

}
