package com.bim.reporte.usuarios.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

	@GetMapping("/test")
	public List<?>GetAll(){
		System.out.println("Test");
		return null;
	}
	
}
