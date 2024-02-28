package com.bim.reporte.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bim.reporte.usuarios.entity.Roles;

public interface RolRepository extends JpaRepository<Roles, Integer>{

}
