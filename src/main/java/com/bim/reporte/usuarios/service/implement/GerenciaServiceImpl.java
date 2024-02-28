package com.bim.reporte.usuarios.service.implement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bim.reporte.usuarios.entity.Gerencia;
import com.bim.reporte.usuarios.repository.GerenciaRepository;
import com.bim.reporte.usuarios.request.GerenciaRequest;
import com.bim.reporte.usuarios.response.GerenciaResponse;
import com.bim.reporte.usuarios.service.GerenciaService;

@Service
public class GerenciaServiceImpl implements GerenciaService{

	@Autowired
	private GerenciaRepository gerenciaRepository;
	
	@Override
	public List<GerenciaResponse> listaGerencias() {
		// TODO Auto-generated method stub
		List<Gerencia> listaGerenciaEnt = gerenciaRepository.findAll();
		
		List<GerenciaResponse> listaGerenciaResponse = listaGerenciaEnt.stream()
				.map(lstGerencia ->  
				new GerenciaResponse(
						lstGerencia.getIdGerencia(),
						lstGerencia.getGerencia()
						)
					).collect(Collectors.toList());
				
		return listaGerenciaResponse;
	}

	@Override
	public void crearGerencia(GerenciaRequest gerenciaRequest) {
		// TODO Auto-generated method stub
		Gerencia gerenciaEnt = new Gerencia();
		
		gerenciaEnt.setGerencia(gerenciaRequest.getGerencia());
		gerenciaEnt.setStatus(gerenciaRequest.isStatus());
		
		gerenciaRepository.save(gerenciaEnt);
	}

	@Override
	public void modificarGerencia(int id, GerenciaRequest gerenciaRequest) {
		// TODO Auto-generated method stub
		Gerencia gerenciaEnt = gerenciaRepository.findById(id).orElseThrow(null);
		
		gerenciaEnt.setGerencia(gerenciaRequest.getGerencia());
		gerenciaEnt.setStatus(gerenciaRequest.isStatus());
		
		gerenciaRepository.save(gerenciaEnt);
	}

	@Override
	public List<GerenciaResponse> listaGerenciasId(int idGerencia) {
		// TODO Auto-generated method stub
		return null;
	}

}
