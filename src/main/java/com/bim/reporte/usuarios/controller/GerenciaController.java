package com.bim.reporte.usuarios.controller;

import java.util.List;
import java.util.Optional;

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
import com.bim.reporte.usuarios.repository.GerenciaRepository;
import com.bim.reporte.usuarios.request.GerenciaRequest;
import com.bim.reporte.usuarios.response.GerenciaResponse;
import com.bim.reporte.usuarios.response.UsuarioResponse;
import com.bim.reporte.usuarios.service.GerenciaService;

@RestController
@RequestMapping("/gerencia")
public class GerenciaController {

	@Autowired
	private GerenciaService gerenciaService;
	
	@Autowired
	private GerenciaRepository gerenciaRepository;
	
	@GetMapping("/listar")
	public ResponseEntity<List<GerenciaResponse>> listaGerencias(){
		return ResponseEntity.ok(gerenciaService.listaGerencias());
	}
	
	@PostMapping("/crear")
	public void guardarGerencia(@RequestBody GerenciaRequest gerenciaRequest) {
		gerenciaService.crearGerencia(gerenciaRequest);
	}
	
	@PutMapping("/modificar/{id}")
	public ResponseEntity<?> guardarGerencia(@PathVariable int id,@RequestBody GerenciaRequest gerenciaRequest) {
		
		Optional<Gerencia> gerenciaEnt = gerenciaRepository.findById(id);
		
		if(gerenciaEnt.equals(null)) {
			return ResponseEntity.notFound().build();
		}
		
		gerenciaService.modificarGerencia(id,gerenciaRequest);
		
		return ResponseEntity.ok("Usuario actualizado correctamente");
    }
	
}
