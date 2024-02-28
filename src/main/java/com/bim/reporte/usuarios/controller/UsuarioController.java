package com.bim.reporte.usuarios.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bim.reporte.usuarios.entity.Gerencia;
import com.bim.reporte.usuarios.entity.ProyectoRecurso;
import com.bim.reporte.usuarios.entity.Recurso;
import com.bim.reporte.usuarios.entity.Usuario;


import com.bim.reporte.usuarios.request.UsuarioRequest;
import com.bim.reporte.usuarios.response.GerenciaResponse;
import com.bim.reporte.usuarios.response.PersonaResponse;
import com.bim.reporte.usuarios.response.RecursosPersonaResponse;
import com.bim.reporte.usuarios.response.RecursosResponse;
import com.bim.reporte.usuarios.response.UsuarioResponse;
import com.bim.reporte.usuarios.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	/*@Autowired
	private ProyectoRecursoRepository proyectoRecursoRepository;*/
	
	
	@GetMapping
	public ResponseEntity<List<UsuarioResponse>> listaUsuarios(){
		return ResponseEntity.ok(usuarioService.listaUsuarios());
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Usuario>>  listaPorGerencia(){
		return ResponseEntity.ok(usuarioService.listaUsuariosGerencia());
	}
	
	/*@GetMapping("/gerenciales")
	public ResponseEntity<List<Gerencia>>  listaPorGerencias(){
		usuarioService.listaRecursosGerencias();
		return ResponseEntity.ok(usuarioService.listaUsuariosGerencias());
	}*/
	
	@GetMapping("/recursosGerencia")
	public ResponseEntity<List<RecursosResponse>>  listaPorGerenciass(){
		
		return ResponseEntity.ok(usuarioService.listaRecursosGerencias());
	}
	
	@GetMapping("/recursosGerencia/{idGerencia}")
	public ResponseEntity<List<RecursosResponse>>  listaRecursosPorGerencia(@PathVariable("idGerencia") int idGerencia){
		
		return ResponseEntity.ok(usuarioService.listaRecursoPorGerencia(idGerencia));
	}
	
	@PostMapping("/usuario")
	public void crearUsuario(@RequestBody UsuarioRequest request) {
		usuarioService.crearUsuario(request);
	}
	
	@PutMapping("/modificar/{idUsuario}")
	public void modificarUsuario(@PathVariable int idUsuario, @RequestBody UsuarioRequest request) {
		usuarioService.modficarUsuario(idUsuario, request);
	}
	
	@GetMapping("/test")
	public ResponseEntity<List<RecursosPersonaResponse>> lis(){
		return ResponseEntity.ok(usuarioService.lista());
	}
	
	@GetMapping("/test/{id}")
	public ResponseEntity<List<RecursosPersonaResponse>> listaGerencia(@PathVariable("id") int idGerencia){
		return ResponseEntity.ok(usuarioService.listaGerencia(idGerencia));
	}
	
	@GetMapping("/listaRecursos")
	public ResponseEntity<List<PersonaResponse>> listarPersona(){
		return ResponseEntity.ok(usuarioService.listaPersonas());
	}
	
	/*@GetMapping("/proyecto")
	public ResponseEntity<List<ProyectoRecurso>> listaProy(){
		return ResponseEntity.ok(proyectoRecursoRepository.findAll());
	}*/
}
