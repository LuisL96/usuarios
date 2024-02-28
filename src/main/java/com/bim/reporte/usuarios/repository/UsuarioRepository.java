package com.bim.reporte.usuarios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bim.reporte.usuarios.entity.Usuario;
import com.bim.reporte.usuarios.response.UsuarioResponse;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	//List<Usuario> findByGerencias(int gerencia);
	
}
